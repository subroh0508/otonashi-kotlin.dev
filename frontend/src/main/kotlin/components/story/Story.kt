package components.story

import kotlinx.html.js.onClickFunction
import materialui.components.button.button
import materialui.components.button.enums.ButtonColor
import materialui.components.dialog.dialog
import materialui.components.dialog.enums.DialogMaxWidth
import materialui.components.dialogactions.dialogActions
import materialui.components.dialogcontent.dialogContent
import materialui.components.dialogcontenttext.dialogContentText
import react.*
import react.dom.a
import react.dom.li
import react.dom.ul
import shared.components.reachrouter.RoutingProps

external interface StoryState : RState {
    var openModal: Boolean
}

val storyView: RClass<RoutingProps>
        get() = rFunction("StoryView") {
            child(Story::class) {}
        }

class Story : RComponent<RProps, StoryState>() {
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

            dialogContent {
                dialogContentText(null) {
                    +"テストテスト"
                }
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