package shared.reachrouter

import react.RClass
import react.RProps

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
