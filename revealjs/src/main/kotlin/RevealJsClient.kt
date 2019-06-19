import kotlinext.js.jsObject

@JsModule("reveal.js")
private external val Reveal: dynamic = definedExternally

fun main() {
    kotlinext.js.require("reveal.js/css/reset.css")
    kotlinext.js.require("reveal.js/css/reveal.css")
    kotlinext.js.require("reveal.js/css/theme/black.css")

    Reveal.initialize(
        jsObject {
            asDynamic()["transition"] = "none"
            asDynamic()["width"] = 1280
            asDynamic()["height"] = 720
        }
    )
}
