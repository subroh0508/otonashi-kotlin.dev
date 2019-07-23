package components.drawer.koans

import org.w3c.dom.events.Event
import shared.components.reachrouter.RoutingProps

external interface KoansDrawerProps : RoutingProps {
    var mobileMenuOpen: Boolean
    var onClose: (Event) -> Unit
}

val KoansDrawerProps.rootStyle: String
    get() = asDynamic()["classes"]["root"] as String
val KoansDrawerProps.navStyle: String
    get() = asDynamic()["classes"]["nav"] as String
val KoansDrawerProps.paperStyle: String
    get() = asDynamic()["classes"]["paper"] as String
val KoansDrawerProps.listItemIconStyle: String
    get() = asDynamic()["classes"]["listItemIcon"] as String
val KoansDrawerProps.listItemDividerStyle: String
    get() = asDynamic()["classes"]["listItemDivider"] as String
