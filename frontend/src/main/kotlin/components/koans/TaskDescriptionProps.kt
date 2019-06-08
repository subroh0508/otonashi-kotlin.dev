package components.koans

import react.RProps

external interface TaskDescriptionProps : RProps

external interface TaskDescriptionHeaderProps : RProps {
    var subtitle: String
    var index: Int
    var onChangeIndex: (Int) -> Unit
}

external interface TaskDescriptionBodyProps : RProps {
    var index: Int
    var description: String
    var avatarSrc: String
    var conversation: String
}

val TaskDescriptionProps.rootStyle: String
    get() = asDynamic()["classes"]["root"] as String
val TaskDescriptionHeaderProps.paginationStyle: String
    get() = asDynamic()["classes"]["pagination"] as String
