package shared

import kotlinx.css.Display
import kotlinx.css.TextAlign
import kotlinx.css.pct
import materialui.styles.childWithStyles
import react.RBuilder
import react.RProps
import react.dom.div
import styled.styledDiv
import styles.balloonStyle

fun RBuilder.balloon(block: RBuilder.() -> Unit) {
    (childWithStyles<RProps>("Balloon", balloonStyle) {
        val style = it.asDynamic()["classes"]["root"] as String

        styledDiv {
            css.display = Display.inlineBlock
            css.width = 100.pct
            css.textAlign = TextAlign.center

            div(style) { it.children() }
        }
    }) { block() }
}