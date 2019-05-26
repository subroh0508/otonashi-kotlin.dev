import react.dom.render
import kotlin.browser.document

@JsModule("kotlin-playground")
external val playground: (String, dynamic) -> dynamic = definedExternally

fun main() {
    render(document.getElementById("root")) {
        child(App::class) {}
    }

    /*
    render(document.getElementById("root")) {
        Router {
            home { attrs.path = "/" }
            dashboard { attrs.path = "dashboard" }
        }
    }
    */
    /*
    window.onload = {
        document.body?.append?.code {
            attributes["data-version"] = "1.3.31"

            +"""
            fun main() {
                print("Hello World!")
            }
            """.trimIndent()
        }

        playground("code", jsObject {  })
    }
    */
}
