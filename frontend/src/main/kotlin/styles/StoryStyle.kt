package styles

import kotlinx.css.px
import materialui.styles.StylesSet

val storyStyle: StylesSet.() -> Unit = {
    "content" {
        height = 768.px
        paddingTop = 24.px
        paddingBottom = 0.px

        children("iframe") {
            height = 720.px
            width = 1280.px
        }
    }
}