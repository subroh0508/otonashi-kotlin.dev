package shared.components

import materialui.styles.childWithStyles
import react.RBuilder
import react.RProps
import react.dom.img
import styles.avatarStyle

fun RBuilder.avatar(src: String, block: RBuilder.() -> Unit) {
    balloon { block() }
    (childWithStyles<RProps>("Avatar", avatarStyle) { props ->
        val style = props.asDynamic()["classes"]["root"] as String

        img(src = src, classes = style) {}
    }) {}
}