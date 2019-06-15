package styles

import kotlinx.css.px
import materialui.styles.StylesSet

val storyStyle: StylesSet.() -> Unit = {
    "content" {
        height = 700.px
        paddingTop = 24.px
        paddingBottom = 0.px

        children("iframe") {
            height = 652.px
        }
    }
}