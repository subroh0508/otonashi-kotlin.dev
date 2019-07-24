package components.koans

import shared.components.reachrouter.RoutingProps

external interface KoansTaskProps : RoutingProps {
    var taskPath: String
    var subtitle: String
    var description: String
}

val KoansTaskProps.rootStyle: String
    get() = asDynamic()["classes"]["root"] as String
val KoansTaskProps.playgroundStyle: String
    get() = asDynamic()["classes"]["playground"] as String
val KoansTaskProps.taskStyle: String
    get() = asDynamic()["classes"]["task"] as String
