package components.koans

import react.RProps

interface PlaygroundProps : RProps {
    var onOpenConsole: (() -> Unit)?
    var onCloseConsole: (() -> Unit)?
    var onChange: ((String) -> Unit)?
    var onTestPassed: (() -> Unit)?
    var onTestFailed: (() -> Unit)?

    var onReceivedMessage: ((Message, String) -> Unit)?
}

interface PlaygroundImplProps : RProps

val PlaygroundImplProps.rootStyle: String
    get() = asDynamic()["classes"]["root"] as String