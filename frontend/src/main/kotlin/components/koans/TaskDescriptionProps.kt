package components.koans

import react.RProps

external interface TaskDescriptionProps : RProps {
    var subtitle: String
    var description: String
}

val TaskDescriptionProps.rootStyle: String
    get() = asDynamic()["classes"]["root"] as String
