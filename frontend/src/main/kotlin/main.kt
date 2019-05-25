
import kotlinext.js.jsObject
import kotlinx.html.code
import kotlinx.html.dom.append
import kotlin.browser.document
import kotlin.browser.window

@JsModule("kotlin-playground")
external val playground: (String, dynamic) -> dynamic = definedExternally

fun main() {
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
}