package components.koans

import shared.reachrouter.RoutingProps

external interface KoansProps : RoutingProps

val KoansProps.rootStyle: String
    get() = asDynamic()["classes"]["root"] as String
val KoansProps.playgroundStyle: String
    get() = asDynamic()["classes"]["playground"] as String
val KoansProps.taskStyle: String
    get() = asDynamic()["classes"]["task"] as String
