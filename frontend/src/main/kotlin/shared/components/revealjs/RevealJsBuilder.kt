package shared.components.revealjs

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
    head {
        title { +"communication" }
        meta(charset = "utf-8")
        meta(name = "viewport", content = "width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no")
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
