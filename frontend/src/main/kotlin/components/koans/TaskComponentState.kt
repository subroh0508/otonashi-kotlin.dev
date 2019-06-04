package components.koans

import react.RState

external interface TaskComponentState : RState {
    var message: Message?
    var outputDetail: String?
    var code: String
    var isInput: Boolean
}