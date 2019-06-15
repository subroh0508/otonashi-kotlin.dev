package components.story

import kotlinx.html.js.onClickFunction
import materialui.components.button.button
import materialui.components.button.enums.ButtonColor
import materialui.components.dialog.dialog
import materialui.components.dialog.enums.DialogMaxWidth
import materialui.components.dialogactions.dialogActions
import materialui.components.dialogcontent.dialogContent
import materialui.styles.childWithStyles
import react.*
import react.dom.a
import react.dom.li
import react.dom.ul
import shared.components.reachrouter.RoutingProps
import shared.components.revealjs.RevealJsComponent
import styles.storyStyle

external interface StoryProps: RoutingProps

val StoryProps.contentStyle: String
    get() = asDynamic()["classes"]["content"] as String

external interface StoryState : RState {
    var openModal: Boolean
}

val RBuilder.storyView: RClass<StoryProps>
    get() = this.childWithStyles("StoryView", storyStyle) { props ->
        child(Story::class.js as RClass<StoryProps>, props) {}
    }

class Story : RComponent<StoryProps, StoryState>() {
    override fun StoryState.init() {
        openModal = false
    }

    private fun openModal() {
        setState { openModal = true }
    }

    private fun closeModal() {
        setState { openModal = false }
    }

    override fun RBuilder.render() {
        li {
            ul {
                a {
                    attrs.onClickFunction = { openModal() }
                    +"開く"
                }
            }
        }

        dialog {
            attrs.fullWidth = true
            attrs.maxWidth = DialogMaxWidth.xl
            attrs.open = state.openModal
            attrs.onClose = { _, _ -> closeModal() }

            dialogContent(props.contentStyle) {
                child(RevealJsComponent::class) {}
            }

            dialogActions {
                button {
                    attrs.onClickFunction = { closeModal() }
                    attrs.color = ButtonColor.primary

                    +"閉じる"
                }
            }
        }
    }
}