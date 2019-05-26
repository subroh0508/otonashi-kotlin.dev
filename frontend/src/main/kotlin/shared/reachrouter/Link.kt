package shared.reachrouter

import react.RClass
import react.RProps

@JsModule("@reach/router")
private external val routerModule: dynamic = definedExternally

external interface LinkProps: RProps {
    var to: String
}

val Link: RClass<LinkProps> = routerModule.Link as RClass<LinkProps>