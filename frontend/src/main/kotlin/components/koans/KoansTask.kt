package components.koans

import components.koans.sections.Section
import io.ktor.client.request.get
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.css.*
import materialui.components.typography.enums.TypographyVariant
import materialui.components.typography.typography
import react.RBuilder
import react.RComponent
import react.dom.div
import react.rFunction
import react.setState
import shared.clients.client
import shared.components.reachrouter.RoutingProps
import styled.styledDiv

fun RBuilder.koansTask(section: Section) {
    Section {
        attrs.path = section.pathname

        section.tasks.forEach { task ->
            KoansTaskContainer {
                attrs.path = task.pathname
                attrs.taskPath = "${section.pathname}/${task.pathname}"
            }
        }

        Default { attrs.default = true }
    }
}

private class KoansTask : RComponent<KoansTaskProps, KoansTaskState>() {
    override fun KoansTaskState.init() {
        index = 0
        initialCode = ""
        avatarSrc = ""
        ok = false
    }

    private val taskPath: String
        get() = "http://localhost:8088/sections/${props.taskPath}.kt"

    override fun componentDidMount() {
        GlobalScope.launch { fetchCode() }
        GlobalScope.launch { startConversations() }
    }

    override fun componentDidUpdate(prevProps: KoansTaskProps, prevState: KoansTaskState, snapshot: Any) {
        if (prevProps.taskPath != props.taskPath) {
            GlobalScope.launch { fetchCode() }
        }
    }

    private suspend fun fetchCode() {
        val code = client.get<String>(taskPath)

        setState { initialCode = code }
    }

    private suspend fun startConversations() {
        val startConversationPath = "http://localhost:8080/api/v1/${props.taskPath}/start_conversations"
        val conversation: Conversation = JSON.parse(client.get(startConversationPath))

        setState {
            this.conversation = conversation.message
            avatarSrc = conversation.avatar
        }
    }

    private suspend fun codingConversations(code: String) {
        if (state.ok || state.index == 0) return

        val codingConversationPath = "http://localhost:8080/api/v1/${props.taskPath}/coding_conversations?code=$code"
        val conversation: Conversation = JSON.parse(client.get(codingConversationPath))

        setState {
            this.conversation = conversation.message
            avatarSrc = conversation.avatar
        }
    }

    private suspend fun validateTaskResult(message: Message, outputDetail: String?) {
        val taskResultPath = "http://localhost:8080/api/v1/${props.taskPath}/task_results?output=$outputDetail&status=$message"
        val taskResult: TaskResult = JSON.parse(client.get(taskResultPath))

        setState {
            this.ok = taskResult.status == "SUCCESS"
            this.conversation = taskResult.message
            avatarSrc = taskResult.avatar
        }
    }

    private fun onReceivedMessage(message: Message, output: String?) {
        GlobalScope.launch { validateTaskResult(message, output) }
    }

    private fun onChangeCode(code: String) {
        GlobalScope.launch { codingConversations(code) }
    }

    private fun onChangeIndex(i: Int) {
        setState { index = i }
    }

    override fun RBuilder.render() {
        child<PlaygroundProps, Playground> {
            attrs.initialCode = state.initialCode
            attrs.onReceivedMessage = this@KoansTask::onReceivedMessage
            attrs.onChange = this@KoansTask::onChangeCode
        }

        taskDescription {
            taskDescriptionHeader {
                attrs.index = state.index
                attrs.onChangeIndex = this@KoansTask::onChangeIndex
                attrs.subtitle = "全てはここから、「Hello, World!」"
            }

            taskDescriptionBody {
                attrs.index = state.index
                attrs.description = "ほげほげ"
                attrs.avatarSrc = state.avatarSrc
                attrs.conversation = state.conversation
            }
        }
    }
}

private val KoansTaskContainer = rFunction<KoansTaskProps>("KoansTaskContainer") { props ->
    styledDiv {
        css.display = Display.flex
        css.height = 100.vh
        css.width = 100.vw - 240.px
        css.position = Position.fixed

        child(KoansTask::class) {
            attrs.taskPath = props.taskPath
        }
    }
}

private val Section = rFunction<RoutingProps>("Section") {
    it.children()
}

private val Default = rFunction<RoutingProps>("default") {
    div { typography { attrs.variant = TypographyVariant.h1; +"Default" } }
}

external class Conversation {
    val message: String
    val avatar: String
}

external class TaskResult {
    val status: String
    val message: String
    val avatar: String
}
