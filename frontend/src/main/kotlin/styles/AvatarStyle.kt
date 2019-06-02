package styles

import kotlinx.css.*
import materialui.styles.StylesSet

val avatarStyle: StylesSet.() -> Unit = {
    "root" {
        display = Display.block
        width = 60.pct
        objectFit = ObjectFit.cover
        objectPosition = "0 0"
        margin(horizontal = LinearDimension.auto)
    }
}