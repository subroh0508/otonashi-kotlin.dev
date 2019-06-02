package styles

import kotlinx.css.*
import kotlinx.css.properties.border
import kotlinx.css.properties.borderTop
import materialui.styles.StylesSet

val balloonStyle: StylesSet.() -> Unit = {
    "root" {
        position = Position.relative
        display = Display.inlineBlock
        margin(1.5.em, 0.px)
        padding(7.px, 10.px)
        width = 400.px
        border(3.px, BorderStyle.solid, Color("#555"))
        boxSizing = BoxSizing.borderBox
        textAlign = TextAlign.center

        before {
            position = Position.absolute
            bottom = (-24).px
            left = 50.pct
            marginLeft = (-15).px
            border(12.px, BorderStyle.solid, Color.transparent)
            borderTop(12.px, BorderStyle.solid, Color("#FFF"))
            zIndex = 2
        }

        after {
            position = Position.absolute
            bottom = (-30).px
            left = 50.pct
            marginLeft = (-17).px
            border(14.px, BorderStyle.solid, Color.transparent)
            borderTop(14.px, BorderStyle.solid, Color("#555"))
            zIndex = 1
        }

        descendants("p") {
            margin(0.px)
            padding(0.px)
            width = 100.pct
            wordBreak = WordBreak.keepAll
        }
    }
}