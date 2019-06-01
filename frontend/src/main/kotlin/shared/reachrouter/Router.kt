package shared.reachrouter

import react.RBuilder
import react.RClass
import react.RProps
import react.rFunction

@JsModule("@reach/router")
private external val routerModule: dynamic = definedExternally

external interface RouterProps: RProps {
    var location: dynamic
    var basepath: String
}

external interface RoutingProps: RProps {
    var path: String
    var default: Boolean
}

val Router: RClass<RouterProps> = routerModule.Router as RClass<RouterProps>

fun <P: RoutingProps> componentWithPath(displayName: String, render: RBuilder.(P) -> Unit = { it.children() })
        = rFunction(displayName, render)
