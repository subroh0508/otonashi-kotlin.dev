package components.koans

import kotlinx.css.*
import materialui.components.typography.enums.TypographyVariant
import materialui.components.typography.typography
import materialui.styles.childWithStyles
import react.RBuilder
import react.RComponent
import react.dom.div
import react.dom.p
import react.setState
import shared.avatar
import styled.styledDiv
import styles.taskStyle

class Task : RComponent<TaskProps, TaskState>() {
    override fun TaskState.init() {
        message = null
        outputDetail = null
        code = ""
        isInput = false
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

    private fun RBuilder.root(render: RBuilder.(TaskProps) -> Unit)
            = (childWithStyles<TaskProps>("Task", taskStyle) { props ->
                div(props.rootStyle) { render(props) }
            }) { }

    override fun RBuilder.render() {
        styledDiv {
            css.display = Display.flex
            css.height = 100.vh
            css.width = 100.vw - 240.px
            css.position = Position.fixed

            child<PlaygroundProps, Playground> {
                attrs.onReceivedMessage = this@Task::onReceivedMessage
                attrs.onChange = { onChangeCode(it) }
            }

            root {
                typography(p = true) {
                    attrs.variant = TypographyVariant.h6

                    +"全てはここから、「Hello, World!」"
                }

                avatar()
            }
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
