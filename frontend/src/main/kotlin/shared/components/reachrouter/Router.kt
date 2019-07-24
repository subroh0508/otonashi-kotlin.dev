package shared.components.reachrouter

import react.RBuilder
import react.RClass
import react.RProps
import react.dom.div
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

fun <P: RoutingProps> componentWithPath(
    displayName: String,
    render: RBuilder.(P) -> Unit = { div { it.children() } }
) = rFunction(displayName, render)

fun <P: RoutingProps> RBuilder.nestedRouting(
    displayName: String,
    baseUrl: String,
    vararg components: Pair<String, RBuilder.() -> Unit>
) = (rFunction<P>(displayName) { it.children() }) {
    attrs.path = baseUrl

    components.forEach { (path, render) ->
        (rFunction<RoutingProps>(path) { render() }) { attrs.path = path }
    }
}

