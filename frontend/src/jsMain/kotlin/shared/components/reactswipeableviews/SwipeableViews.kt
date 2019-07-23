package shared.components.reactswipeableviews

import react.RClass
import react.RProps

@JsModule("react-swipeable-views")
private external val reactSwipeableViewModule: dynamic

external interface ReactSwipeableProps : RProps {
    var index: Int
    var disabled: Boolean
    var onChangeIndex: (Int, Int, ChangeReason) -> Unit
    var onSwitching: (Int, String) -> Unit
}

fun ReactSwipeableProps.onChangeIndex(block: (Int, Int?, ReasonType?) -> Unit) {
    onChangeIndex = { index: Int, indexLatest: Int, reason: ChangeReason ->
        block(index, indexLatest, ReasonType.valueOf(reason.reason))
    }
}

fun ReactSwipeableProps.onChangeIndex(block: (Int, Int?) -> Unit) {
    onChangeIndex = { index: Int, indexLatest: Int, _ -> block(index, indexLatest) }
}

fun ReactSwipeableProps.onChangeIndex(block: (Int) -> Unit) {
    onChangeIndex = { index: Int, _, _ -> block(index) }
}

fun ReactSwipeableProps.onSwitching(block: (Int, SwitchingType) -> Unit) {
    onSwitching = { index: Int, type: String -> block(index, SwitchingType.valueOf(type)) }
}

external interface ChangeReason {
    var reason: String
}

@Suppress("EnumEntryName")
enum class ReasonType {
    swipe, focus
}

@Suppress("EnumEntryName")
enum class SwitchingType {
    move, end
}

val SwipeableViews: RClass<ReactSwipeableProps>
        = reactSwipeableViewModule.default as RClass<ReactSwipeableProps>