package components.koans

import components.koans.sections.Section
import react.RProps

external interface TaskProps : RProps {
    var task: Section
}

val TaskProps.rootStyle: String
    get() = asDynamic()["classes"]["root"] as String
