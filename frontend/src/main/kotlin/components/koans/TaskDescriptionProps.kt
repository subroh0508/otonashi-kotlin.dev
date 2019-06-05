package components.koans

import react.RProps

external interface TaskDescriptionProps : RProps {
    var subtitle: String
    var description: String
    var avatarSrc: String
    var conversation: String
    var onChangeIndex: (Int) -> Unit
}

val TaskDescriptionProps.rootStyle: String
    get() = asDynamic()["classes"]["root"] as String
val TaskDescriptionProps.paginationStyle: String
    get() = asDynamic()["classes"]["pagination"] as String
