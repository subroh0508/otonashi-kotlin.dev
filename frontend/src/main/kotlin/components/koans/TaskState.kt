package components.koans

import react.RState

external interface TaskState : RState {
    var message: Message?
    var outputDetail: String?
    var code: String
    var isInput: Boolean
}