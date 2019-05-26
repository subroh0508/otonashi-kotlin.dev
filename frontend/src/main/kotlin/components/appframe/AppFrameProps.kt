package components.appframe

import react.RProps

external interface AppFrameProps : RProps {
    var pathname: String
}

val AppFrameProps.rootStyle: String
    get() = asDynamic()["classes"]["root"] as String
val AppFrameProps.toolbarStyle: String
    get() = asDynamic()["classes"]["toolbar"] as String
val AppFrameProps.titleStyle: String
    get() = asDynamic()["classes"]["title"] as String
val AppFrameProps.navigationsStyle: String
    get() = asDynamic()["classes"]["navigations"] as String
