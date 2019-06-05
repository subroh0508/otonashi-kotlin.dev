package components.koans

import kotlinx.html.js.onClickFunction
import materialui.components.icon.enums.IconColor
import materialui.components.icon.icon
import materialui.components.iconbutton.iconButton
import materialui.components.typography.enums.TypographyVariant
import materialui.components.typography.typography
import materialui.styles.childWithStyles
import react.RBuilder
import react.RComponent
import react.dom.WithClassName
import react.dom.div
import react.dom.p
import react.rFunction
import react.setState
import shared.components.avatar
import shared.components.reactswipeableviews.SwipeableViews
import styles.taskStyle

val RBuilder.taskDescription
    get() = (childWithStyles<TaskDescriptionProps>("Description", taskStyle) { props ->
        div(props.rootStyle) {
            node(TaskDescription::class, props)
        }
    })

class TaskDescription : RComponent<TaskDescriptionProps, TaskDescriptionState>() {
    override fun TaskDescriptionState.init() {
        index = 0
    }

    private fun onChangeIndex(i: Int) {
        props.onChangeIndex(i)

        console.log(i)
        setState { index = i }
    }

    private fun RBuilder.root(render: RBuilder.(TaskDescriptionProps) -> Unit)
            = (childWithStyles<TaskDescriptionProps>("Description", taskStyle) { props ->
                div(props.rootStyle) { render(props) }
            }).node(props)

    override fun RBuilder.render() {
        root { props ->
            typography(p = true) {
                attrs.variant = TypographyVariant.h6

                +(props.subtitle)
            }

            Pagination {
                attrs.className = props.paginationStyle
                attrs.index = state.index
                attrs.onChangeIndex = this@TaskDescription::onChangeIndex
            }

            SwipeableViews {
                attrs.index = state.index

                typography(p = true) {
                    +(props.description)
                }

                div {
                    avatar(props.avatarSrc) {
                        p { +(props.conversation) }
                    }
                }
            }
        }
    }
}

private external interface PaginationProps : WithClassName {
    var index: Int
    var onChangeIndex: (Int) -> Unit
}

private val Pagination = rFunction<PaginationProps>("Pagination") { props ->
    fun showDescription() = props.onChangeIndex(0)
    fun showConversation() = props.onChangeIndex(1)

    val descriptionIconColor = if (props.index == 1) IconColor.action else IconColor.disabled
    val conversationIconColor = if (props.index == 0) IconColor.action else IconColor.disabled

    div(props.className) {
        iconButton {
            attrs.onClickFunction = { showDescription() }
            attrs.disabled = props.index == 0

            icon {
                attrs.color = descriptionIconColor

                +"arrow_back"
            }
        }

        iconButton {
            attrs.onClickFunction = { showConversation() }
            attrs.disabled = props.index == 1

            icon {
                attrs.color = conversationIconColor

                +"arrow_forward"
            }
        }
    }
}
