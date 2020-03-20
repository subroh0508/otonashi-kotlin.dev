package styles

import kotlinx.css.*
import materialui.styles.StylesSet
import materialui.styles.breakpoint.Breakpoint
import materialui.styles.breakpoint.up

val appFrameStyle: StylesSet.() -> Unit = {
    "root" {
        flexGrow = 1.0
        zIndex = theme.zIndex.drawer.toInt() + 1
    }
    "toolbar" {
        height = 80.px
    }
    "menuButton" {
        marginRight = theme.spacing(2)
        (theme.breakpoints.up(Breakpoint.sm)) {
            display = Display.none
        }
    }
    "title" {
        height = 100.pct
    }
    "navigations" {
        height = 100.pct
        marginLeft = LinearDimension.auto
        marginRight = 30.px

        children("button") {
            height = 100.pct
            padding(horizontal = 20.px)
        }
    }
}
