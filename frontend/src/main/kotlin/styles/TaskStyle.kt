package styles

import kotlinx.css.Display
import kotlinx.css.padding
import kotlinx.css.pct
import kotlinx.css.px
import materialui.styles.StylesSet

val taskStyle: StylesSet.() -> Unit = {
    "playground" {
        display = Display.flex
        width = 100.pct

        children("div") {
            lastChild {
                width = 100.pct
                padding(24.px)
            }
        }
    }
    "root" {
        display = Display.flex
    }
}