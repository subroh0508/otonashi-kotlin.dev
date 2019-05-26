package styles

import kotlinx.css.LinearDimension
import kotlinx.css.padding
import kotlinx.css.pct
import kotlinx.css.px
import materialui.styles.StylesSet

val appFrameStyle: StylesSet.() -> Unit = {
    "root" {
        flexGrow = 1.0
    }
    "toolbar" {
        height = 80.px
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