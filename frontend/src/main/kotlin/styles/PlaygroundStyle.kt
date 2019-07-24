package styles

import kotlinx.css.*
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