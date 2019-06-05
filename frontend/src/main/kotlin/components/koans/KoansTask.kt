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
                attrs.taskPath = "sections/${section.pathname}/${task.pathname}"
            }
        }

        Default { attrs.default = true }
    }
}

private class KoansTask : RComponent<KoansTaskProps, KoansTaskState>() {
    override fun KoansTaskState.init() {
        index = 0
        message = null
        outputDetail = null
        code = ""
        initialCode = ""
        isInput = false
    }

    private val taskPath: String
        get() = "http://localhost:8088/${props.taskPath}.kt"

    override fun componentDidMount() {
        GlobalScope.launch { fetchCode() }
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

    private fun onReceivedMessage(message: Message, output: String?) {
        setState {
            this.message = message
            outputDetail = output
            isInput = false
        }
    }

    private fun onChangeCode(code: String) {
        setState {
            isInput = this.code.isNotBlank()
            this.code = code
        }
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

        val (avatarSrc, conversation) = conversations()

        child<TaskDescriptionProps, TaskDescription> {
            attrs.onChangeIndex = this@KoansTask::onChangeIndex
            attrs.subtitle = "全てはここから、「Hello, World!」"
            attrs.description = "ほげほげ"
            attrs.avatarSrc = avatarSrc
            attrs.conversation = conversation
        }
    }

    private fun conversations(): Pair<String, String> {
        if (state.message == Message.output) {
            return when (state.outputDetail) {
                "Hello, World!\n" -> "/kotori/success_1.png" to "できました！最初の課題、クリアしましたよ！プロデューサーさん！"
                else -> "/kotori/failed_1.png" to "惜しい…！後は表示させる言葉を直すだけですね。"
            }
        }

        if (state.message == Message.error) {
            return "/kotori/failed_2.png" to "動きません…。書き方を間違えちゃったみたいですね…。"
        }

        if (state.isInput) {
            return when {
                state.code.contains("TODO") -> "/kotori/motivated_1.png" to "『TODO()』って書いてあるところを直すんですね、やってみます！"
                else -> "/kotori/motivated_1.png" to "えっと、ここをこうして…"
            }
        }

        return "/kotori/normal.png" to "最初の課題は、「『Hello, World!』を画面に表示させよう！」ですか…。何事もまずは挨拶から、ってことかしら…？"
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
