package components.koans

import kotlinx.css.Display
import materialui.styles.childWithStyles
import react.RBuilder
import react.RComponent
import react.dom.div
import react.setState
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
                render(props)
            }) { }

    override fun RBuilder.render() {
        styledDiv {
            css.display = Display.flex

            child<PlaygroundProps, Playground> {
                attrs.onReceivedMessage = this@Task::onReceivedMessage
                attrs.onChange = { onChangeCode(it) }
            }

            root {
                div { +"解説的な" }
            }
        }
    }
}
