package components.koans

import materialui.components.typography.enums.TypographyVariant
import materialui.components.typography.typography
import materialui.styles.childWithStyles
import react.RBuilder
import react.dom.div
import react.rFunction
import styles.taskStyle

val RBuilder.taskDescription
    get() = (childWithStyles<TaskDescriptionProps>("Description", taskStyle) { props ->
        div(props.rootStyle) {
            TaskDescription {}
        }
    })

private val TaskDescription = rFunction<TaskDescriptionProps>("Desctription") { props ->
    typography(p = true) {
        attrs.variant = TypographyVariant.h6

        +(props.subtitle)
    }
}
