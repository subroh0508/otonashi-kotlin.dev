package components.koans

import components.koans.sections.Section
import components.koans.sections.Task
import react.RProps

external interface TaskComponentProps : RProps {
    var section: Section
    var task: Task
}

val TaskComponentProps.taskPath: String
    get() = "${section.pathname}/${task.pathname}.kt"

val TaskComponentProps.rootStyle: String
    get() = asDynamic()["classes"]["root"] as String
