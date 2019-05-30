package components.koans

import org.w3c.dom.events.Event
import shared.reachrouter.NavigateOption
import shared.reachrouter.RoutingProps
import kotlin.js.Promise

external interface KoansProps : RoutingProps {
    var mobileMenuOpen: Boolean
    var onDrawerClose: (Event) -> Unit
    var navigate: (String, NavigateOption) -> Promise<dynamic>
}

val KoansProps.rootStyle: String
    get() = asDynamic()["classes"]["root"] as String
