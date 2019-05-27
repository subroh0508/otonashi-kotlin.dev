package components.koans

import org.w3c.dom.events.Event
import shared.reachrouter.RoutingProps

external interface KoansProps : RoutingProps {
    var mobileMenuOpen: Boolean
    var onDrawerClose: (Event) -> Unit
}

val KoansProps.rootStyle: String
    get() = asDynamic()["classes"]["root"] as String
