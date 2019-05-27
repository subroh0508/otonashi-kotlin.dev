package components.appframe

import react.RProps

external interface AppFrameProps : RProps

val AppFrameProps.rootStyle: String
    get() = asDynamic()["classes"]["root"] as String
val AppFrameProps.toolbarStyle: String
    get() = asDynamic()["classes"]["toolbar"] as String
val AppFrameProps.menuButtonStyle: String
    get() = asDynamic()["classes"]["menuButton"] as String
val AppFrameProps.titleStyle: String
    get() = asDynamic()["classes"]["title"] as String
val AppFrameProps.navigationsStyle: String
    get() = asDynamic()["classes"]["navigations"] as String
val AppFrameProps.drawerStyle: String
    get() = asDynamic()["classes"]["drawer"] as String