package components.story

import kotlinx.html.js.onClickFunction
import materialui.components.button.button
import materialui.components.button.enums.ButtonColor
import materialui.components.card.card
import materialui.components.cardactions.cardActions
import materialui.components.cardheader.cardHeader
import materialui.components.dialog.dialog
import materialui.components.dialog.enums.DialogMaxWidth
import materialui.components.dialogactions.dialogActions
import materialui.components.dialogcontent.dialogContent
import materialui.components.grid.enums.GridStyle
import materialui.components.grid.grid
import materialui.components.icon.icon
import materialui.components.modal.modal
import materialui.components.typography.enums.TypographyColor
import materialui.components.typography.typography
import materialui.styles.childWithStyles
import react.*
import react.dom.a
import react.dom.div
import react.dom.img
import react.dom.span
import shared.components.reachrouter.RoutingProps
import shared.components.revealjs.RevealJsComponent
import styles.storyStyle

external interface StoryProps: RoutingProps

val StoryProps.rootStyle: String
    get() = asDynamic()["classes"]["root"] as String

val StoryProps.contentStyle: String
    get() = asDynamic()["classes"]["content"] as String

val StoryProps.messageBoxStyle: String
    get() = asDynamic()["classes"]["messageBox"] as String

external interface StoryState : RState {
    var openModal: Boolean
    var showMillionJewel: Boolean
}

val RBuilder.storyView: RClass<StoryProps>
    get() = this.childWithStyles("StoryView", storyStyle) { props ->
        child(Story::class.js as RClass<StoryProps>, props) {}
    }

class Story : RComponent<StoryProps, StoryState>() {
    override fun StoryState.init() {
        openModal = false
        showMillionJewel = false
    }

    private fun openModal() {
        setState { openModal = true }
    }

    private fun closeModal() {
        setState { openModal = false; showMillionJewel = true }
    }

    override fun RBuilder.render() {
        grid(GridStyle.container to props.rootStyle) {
            attrs.container = true
            attrs.spacing(8)

            grid {
                attrs.item = true
                attrs.xs(4)
                attrs.sm(3)

                card {
                    attrs.onClickFunction = { openModal() }

                    cardHeader {
                        attrs.title {
                            typography {
                                attrs.color = TypographyColor.inherit

                                +"プロローグ"
                            }
                        }
                    }

                    img { attrs.src = "/clip/17.png"; attrs.width = "100%" }

                    cardActions {}
                }
            }
        }

        modal {
            attrs.open = state.showMillionJewel

            div(props.messageBoxStyle) {
                div("msgbox") {
                    div("msgboxtop") {
                        +"コミュ達成報酬"
                    }
                    div("msgboxbody") {
                        div {
                            img {
                                attrs.src = "/clip/jewel.jpg"
                            }

                            span("itemname") {
                                +"ミリオンジュエル"

                                span("red") { +"50" }
                                +"個"
                            }
                        }

                        div("notice") {
                            span {
                                icon { +"error_icon" }

                                +"獲得したアイテムはプレゼントから受け取れます"
                            }
                        }
                    }
                    div("msgboxfoot") {
                        a(classes = "button") {
                            attrs.onClickFunction = { setState { showMillionJewel = false } }

                            +"閉じる"
                        }
                    }
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