package components.appframe

import kotlinext.js.jsObject

external class Navigation {
    var id: String
    var displayName: String
    var pathname: String
    var hasDrawer: Boolean
}

val home: Navigation = jsObject {
    id = "home"
    displayName = "ホーム"
    pathname = "/"
    hasDrawer = false
}

val story: Navigation = jsObject {
    id = "story"
    displayName = "ストーリー"
    pathname = "story"
    hasDrawer = true
}

val learn: Navigation = jsObject {
    id = "learn"
    displayName = "学習: 座学編"
    pathname = "learn"
    hasDrawer = true
}

val koans: Navigation = jsObject {
    id = "koans"
    displayName = "学習: 実践編"
    pathname = "koans"
    hasDrawer = true
}
