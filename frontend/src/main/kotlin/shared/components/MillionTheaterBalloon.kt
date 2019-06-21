package shared.components

import kotlinx.html.*

fun SECTION.millionBalloon(
    name: String,
    withTakagi: Boolean = false,
    block: DIV.() -> Unit
) {
    div("balloon-container") {
        if (withTakagi) {
            div("takagi") {
                img(src = "takagi.png")
            }
        }

        div("million-balloon") {
            span("character-name") { +name }
            div("script", block = block)
        }
    }
}