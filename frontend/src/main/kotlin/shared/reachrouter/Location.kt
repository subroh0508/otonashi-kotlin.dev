package shared.reachrouter

import kotlinext.js.jsObject
import react.RBuilder
import react.RConsumer
import react.RProps
import kotlin.js.Promise

@JsModule("@reach/router")
private external val routerModule: dynamic = definedExternally

external interface LocationProps: RProps {
    var location: Location
    val navigate: (String, NavigateOption) -> Promise<dynamic>
}

external interface Location {
    var hash: String
    var host: String
    var hostname: String
    var href: String
    var key: String
    var origin: String
    var pathname: String
    var port: String
    var protcol: String
}

external interface NavigateOption {
    var state: dynamic
    var replace: Boolean
}

val LocationConsumer: RConsumer<LocationProps> = routerModule.Location as RConsumer<LocationProps>

fun RBuilder.location(render: RBuilder.(LocationProps) -> Unit) = LocationConsumer.invoke(render)

private val navigate = routerModule.navigate as (String, NavigateOption) -> Promise<dynamic>

fun navigate(href: String) = navigate(href, jsObject {  })
