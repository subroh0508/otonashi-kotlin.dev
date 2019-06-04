package components.koans

import components.koans.sections.Task
import react.RProps

external interface TaskComponentProps : RProps {
    var task: Task
}

val TaskComponentProps.rootStyle: String
    get() = asDynamic()["classes"]["root"] as String
