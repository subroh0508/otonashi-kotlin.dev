package components.appframe

import react.RState

external interface AppFrameState : RState {
    var currentPage: Navigation
    var mobileMenuOpen: Boolean
}