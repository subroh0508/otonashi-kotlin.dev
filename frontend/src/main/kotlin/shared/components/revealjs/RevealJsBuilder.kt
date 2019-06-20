package shared.components.revealjs

import kotlinx.css.*
import kotlinx.css.properties.borderLeft
import kotlinx.css.properties.borderTop
import kotlinx.css.properties.boxShadow
import kotlinx.html.*
import kotlinx.html.stream.createHTML
import kotlin.browser.document

fun revealBuilder(id: String, block: DIV.() -> Unit) {
    val iframe = document.getElementById(id)?.asDynamic() ?: return

    val doc = iframe["contentDocument"]

    doc.open()
    doc.write(createFrame(block))
    doc.close()
}

private fun createFrame(block : DIV.() -> Unit = {}): String = createHTML().html {
    val css: CSSBuilder = CSSBuilder().apply {
        ".million-balloon" {
            width = 1280.px
            height = 720.px
            margin(0.px, LinearDimension.auto)
            borderRadius = 5.px

            children("span") {
                backgroundColor = rgba(0, 0, 0, 0.3)
                color = Color("#fff")
                paddingTop = 10.px
                paddingBottom = 3.px
                paddingRight = 45.px
                borderTopLeftRadius = 5.px
                borderTop(1.px, BorderStyle.solid, rgb(210, 201, 183))
                borderLeft(1.px, BorderStyle.solid, rgb(210, 201, 183))

                before {
                    width = 10.px
                    height = 29.px
                    marginRight = 10.px
                    top = 6.px
                    content = "".quoted
                    display = Display.inlineBlock
                    position = Position.relative
                    background = "linear-gradient(${rgb(254, 251, 154)}, ${rgb(179, 158, 109)})"
                    borderTopLeftRadius = 4.px
                }

                after {
                    width = 0.px
                    height = 0.px
                    top = 6.px
                    left = 70.px
                    content = "".quoted
                    display = Display.inlineBlock
                    position = Position.relative
                    borderStyle = BorderStyle.solid
                    borderTopWidth = 30.px
                    borderLeftWidth = 25.px
                    borderTopColor = Color.transparent
                    borderRightColor = Color.transparent
                    borderBottomColor = Color.transparent
                    borderLeftColor = rgba(0, 0, 0, 0.3)
                }
            }

            children(".script") {
                backgroundColor = rgba(0, 0, 0, 0.3)
                height = 42.px
                margin(0.px)
                padding(10.px, 20.px)
                borderTopLeftRadius = 0.px
                borderTopRightRadius = 5.px
                borderBottomRightRadius = 5.px
                borderBottomLeftRadius = 5.px
                borderLeft(1.px, BorderStyle.solid, rgb(201, 201, 183))
                boxShadow(
                    rgba(0, 0, 0, 0.2),
                    offsetX = 0.px,
                    offsetY = 1.px,
                    blurRadius = 3.px
                )

                children("p") {
                    margin(0.px, 0.px, 5.px)
                    color = Color("#fff")

                    after {
                        content = "".quoted
                        height = 5.px
                        width = 100.pct
                    }
                }
            }
        }
    }

    head {
        title { +"communication" }
        meta(charset = "utf-8")
        meta(name = "viewport", content = "width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no")
        link(rel = "stylesheet", type = "text/css", href = "/million-balloon.css")
    }
    body {
        div("reveal") {
            div("slides") {
                block()
            }
        }
        script(type = "text/javascript", src = "/revealjs-client.bundle.js", block = {})
    }
}
