
import react.RClass
import react.RProps
import react.dom.div
import react.dom.render
import react.rFunction
import kotlin.browser.document

@JsModule("@reach/router")
external val routerModule: dynamic = definedExternally

val Router: RClass<RProps> = routerModule.Router

@JsModule("kotlin-playground")
external val playground: (String, dynamic) -> dynamic = definedExternally

fun main() {
    render(document.getElementById("root")) {
        Router {
            home { attrs.path = "/" }
            dashboard { attrs.path = "dashboard" }
        }
    }
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

val home = rFunction<RouterProps>("Home") {
    div { +"Home" }
}

val dashboard = rFunction<RouterProps>("Dashboard") {
    div { +"Dashboard" }
}

external interface RouterProps: RProps {
    var path: String
}

external interface Home : RClass<RouterProps>
