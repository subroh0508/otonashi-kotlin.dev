package shared

import materialui.styles.childWithStyles
import react.RBuilder
import react.RProps
import react.dom.div
import styles.balloonStyle

fun RBuilder.balloon(block: RBuilder.() -> Unit) {
    (childWithStyles<RProps>("Balloon", balloonStyle) {
        val style = it.asDynamic()["classes"]["root"] as String

        div(style) { it.children() }
    }) { block() }
}