package components.appframe

import kotlinext.js.jsObject

external class Navigation {
    var id: String
    var displayName: String
    var pathname: String
}

val home: Navigation = jsObject {
    id = "home"
    displayName = "ホーム"
    pathname = "/"
}

val story: Navigation = jsObject {
    id = "story"
    displayName = "ストーリー"
    pathname = "story"
}

val learn: Navigation = jsObject {
    id = "learn"
    displayName = "学習: 座学編"
    pathname = "learn"
}

val koans: Navigation = jsObject {
    id = "koans"
    displayName = "学習: 実践編"
    pathname = "koans"
}
