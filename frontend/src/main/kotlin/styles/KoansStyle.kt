package styles

import kotlinx.css.Color
import kotlinx.css.padding
import kotlinx.css.px
import materialui.styles.StylesSet

val koansTaskProps: StylesSet.() -> Unit = {
    "root" {
        flexGrow = 0.6
        minWidth = 450.px
        maxWidth = 600.px
        padding(24.px)
        backgroundColor = Color("#FFF")
    }
}