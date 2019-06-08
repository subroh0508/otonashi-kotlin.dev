package components.koans

import kotlinx.css.Color
import kotlinx.css.padding
import kotlinx.css.px
import kotlinx.html.js.onClickFunction
import materialui.components.icon.enums.IconColor
import materialui.components.icon.icon
import materialui.components.iconbutton.iconButton
import materialui.components.typography.enums.TypographyVariant
import materialui.components.typography.typography
import materialui.styles.childWithStyles
import react.*
import react.dom.WithClassName
import react.dom.div
import react.dom.p
import shared.components.avatar
import shared.components.reactswipeableviews.SwipeableViews
import styled.styledDiv
import styles.taskHeaderStyle

fun RBuilder.taskDescription(render: RBuilder.() -> Unit) {
    styledDiv {
        css.flexGrow = 0.6
        css.minWidth = 450.px
        css.maxWidth = 600.px
        css.padding(24.px)
        css.backgroundColor = Color("#FFF")

        render()
    }
}

val RBuilder.taskDescriptionHeader
    get() = childWithStyles<TaskDescriptionHeaderProps>(
        "DescriptionHeader", taskHeaderStyle
    ) { props ->
        typography(p = true) {
            attrs.variant = TypographyVariant.h6

            +(props.subtitle)
        }

        Pagination {
            attrs.className = props.paginationStyle
            attrs.index = props.index
            attrs.onChangeIndex = props.onChangeIndex
        }
    }

fun RBuilder.taskDescriptionBody(handler: RHandler<TaskDescriptionBodyProps>) = child(TaskDescriptionBody::class, handler)

private class TaskDescriptionBody : RComponent<TaskDescriptionBodyProps, TaskDescriptionBodyState>() {
    override fun TaskDescriptionBodyState.init(props: TaskDescriptionBodyProps) {
        index = if (props.index == undefined) 0 else props.index
    }

    override fun componentDidUpdate(
        prevProps: TaskDescriptionBodyProps,
        prevState: TaskDescriptionBodyState,
        snapshot: Any
    ) {
        if (props.index == undefined || props.index == state.index) {
            return
        }

        setState { index = props.index }
    }

    override fun RBuilder.render() {
        SwipeableViews {
            attrs.index = state.index
            attrs.disabled = true

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

private external interface TaskDescriptionBodyState : RState {
    var index: Int
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
