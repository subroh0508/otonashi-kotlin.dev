package components.koans

import components.koans.sections.Section
import io.ktor.client.request.get
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.css.*
import materialui.components.typography.enums.TypographyVariant
import materialui.components.typography.typography
import materialui.styles.childWithStyles
import react.RBuilder
import react.RComponent
import react.dom.div
import react.dom.p
import react.rFunction
import react.setState
import shared.clients.client
import shared.components.avatar
import shared.components.reachrouter.RoutingProps
import styled.styledDiv
import styles.taskStyle

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

    private fun RBuilder.root(render: RBuilder.() -> Unit)
            = (childWithStyles<TaskDescriptionProps>("Description", taskStyle) { props ->
                div(props.rootStyle) { props.children() }
            }) { render() }

    override fun RBuilder.render() {
        child<PlaygroundProps, Playground> {
            attrs.initialCode = state.initialCode
            attrs.onReceivedMessage = this@KoansTask::onReceivedMessage
            attrs.onChange = this@KoansTask::onChangeCode
        }

        root {
            typography(p = true) {
                attrs.variant = TypographyVariant.h6

                +"全てはここから、「Hello, World!」"
            }

            avatar()
        }
    }

    private fun RBuilder.avatar() {
        if (state.message == Message.output) {
            when (state.outputDetail) {
                "Hello, World!\n" -> avatar("/kotori/success_1.png") {
                    p { +"できました！最初の課題、クリアしましたよ！プロデューサーさん！" }
                }
                else -> avatar("/kotori/failed_1.png") {
                    p { +"惜しい…！後は表示させる言葉を直すだけですね。" }
                }
            }

            return
        }

        if (state.message == Message.error) {
            avatar("/kotori/failed_2.png") {
                p { +"動きません…。書き方を間違えちゃったみたいですね…。" }
            }

            return
        }

        if (state.isInput) {
            when {
                state.code.contains("TODO") -> avatar("/kotori/motivated_1.png") {
                    p { +"『TODO()』って書いてあるところを直すんですね、やってみます！" }
                }
                else -> avatar("/kotori/motivated_1.png") {
                    p { +"えっと、ここをこうして…" }
                }
            }

            return
        }

        avatar("/kotori/normal.png") {
            p { +"最初の課題は、「『Hello, World!』を画面に表示させよう！」ですか…。何事もまずは挨拶から、ってことかしら…？" }
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
