package styles

import kotlinx.css.Display
import kotlinx.css.pct
import kotlinx.css.px
import materialui.styles.StylesSet
import materialui.styles.breakpoint.Breakpoint
import materialui.styles.breakpoint.up

val drawerStyle: StylesSet.() -> Unit = {
    "root" {
        display = Display.flex

        children("div") {
            width = 100.pct
        }
    }
    "nav" {
        width = 240.px
        flexShrink = 0.0
    }
    "paper" {
        paddingTop = 40.px
        width = 240.px

        (theme.breakpoints.up(Breakpoint.sm)) {
            top = 80.px
            paddingTop = 0.px
        }
    }
}