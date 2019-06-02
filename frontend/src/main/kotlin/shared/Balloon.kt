package shared

import kotlinx.css.Position
import kotlinx.css.TextAlign
import kotlinx.css.padding
import kotlinx.css.px
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
            css.position = Position.fixed
            css.padding(horizontal = 24.px)
            css.textAlign = TextAlign.center

            div(style) { it.children() }
        }
    }) { block() }
}