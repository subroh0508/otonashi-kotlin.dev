package styles

import kotlinx.css.padding
import kotlinx.css.pct
import kotlinx.css.px
import materialui.styles.StylesSet

val playgroundStyle: StylesSet.() -> Unit = {
    "root" {
        minWidth = 560.px
        flexGrow = 4.0

        children("div") {
            lastChild {
                width = 100.pct
                padding(24.px)
            }
        }
    }
}