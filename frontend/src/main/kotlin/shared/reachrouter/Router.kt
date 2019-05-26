package shared.reachrouter

import react.RClass
import react.RProps

@JsModule("@reach/router")
private external val routerModule: dynamic = definedExternally

external interface RouterProps: RProps {
    var location: dynamic
}

external interface RoutingProps: RProps {
    var path: String
}

val Router: RClass<RouterProps> = routerModule.Router as RClass<RouterProps>
