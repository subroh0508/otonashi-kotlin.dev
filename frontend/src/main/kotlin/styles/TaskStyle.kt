package styles

import kotlinx.css.*
import materialui.styles.StylesSet

val taskStyle: StylesSet.() -> Unit = {
    "root" {
        flexGrow = 0.6
        minWidth = 450.px
        maxWidth = 600.px
        padding(24.px)
        backgroundColor = Color("#FFF")
    }

    "pagination" {
        display = Display.flex
        justifyContent = JustifyContent.spaceBetween
    }
}