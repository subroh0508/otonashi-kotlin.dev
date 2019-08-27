package styles

import kotlinx.css.Display
import kotlinx.css.JustifyContent
import kotlinx.css.display
import kotlinx.css.justifyContent
import materialui.styles.StylesSet

val koansTaskStyle: StylesSet.() -> Unit = {
    "pagination" {
        display = Display.flex
        justifyContent = JustifyContent.spaceBetween
    }
}