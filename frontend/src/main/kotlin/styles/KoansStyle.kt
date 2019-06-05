package styles

import kotlinx.css.Display
import kotlinx.css.JustifyContent
import materialui.styles.StylesSet

val koansTaskStyle: StylesSet.() -> Unit = {
    "pagination" {
        display = Display.flex
        justifyContent = JustifyContent.spaceBetween
    }
}