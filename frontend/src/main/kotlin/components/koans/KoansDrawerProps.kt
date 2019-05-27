package components.koans

import org.w3c.dom.events.Event
import react.RProps

external interface KoansDrawerProps : RProps {
    var mobileMenuOpen: Boolean
    var onClose: (Event) -> Unit
}

val KoansDrawerProps.navStyle: String
    get() = asDynamic()["classes"]["nav"] as String
val KoansDrawerProps.paperStyle: String
    get() = asDynamic()["classes"]["paper"] as String
