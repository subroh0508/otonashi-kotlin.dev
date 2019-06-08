package components.koans

import react.RState

external interface KoansTaskState : RState {
    var initialCode: String
    var index: Int
    var avatarSrc: String
    var conversation: String
    var ok: Boolean
}