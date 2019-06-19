package shared.components

import kotlinx.html.DIV
import kotlinx.html.SECTION
import kotlinx.html.div
import kotlinx.html.span

fun SECTION.millionBalloon(
    name: String,
    block: DIV.() -> Unit
) {
    div("balloon-container") {
        div("million-balloon") {
            span("character-name") { +name }
            div("script", block = block)
        }
    }
}