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
import shared.balloon
import styled.styledDiv
import styles.taskStyle

class Task : RComponent<TaskProps, TaskState>() {
    override fun TaskState.init() {
        message = null
        outputDetail = null
        code = ""
    }

    private fun onReceivedMessage(message: Message, output: String?) {
        setState {
            this.message = message
            outputDetail = output
        }
    }

    private fun onChangeCode(code: String) {
        setState { this.code = code }
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

                balloon {
                    p { +"最初の課題は、「『Hello, World!』を画面に表示させよう！」ですか…。何事もまずは挨拶から、ってことかしら…？" }
                }
                typography(p = true) {

                }
            }
        }
    }
}
