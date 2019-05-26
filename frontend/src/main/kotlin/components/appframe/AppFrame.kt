package components.appframe

import kotlinx.html.id
import kotlinx.html.js.onClickFunction
import materialui.components.appbar.appBar
import materialui.components.appbar.enums.AppBarColor
import materialui.components.appbar.enums.AppBarPosition
import materialui.components.appbar.enums.AppBarStyle
import materialui.components.button.button
import materialui.components.button.enums.ButtonColor
import materialui.components.button.enums.ButtonVariant
import materialui.components.toolbar.enums.ToolbarStyle
import materialui.components.toolbar.toolbar
import materialui.components.typography.enums.TypographyVariant
import materialui.components.typography.typography
import react.RBuilder
import react.RComponent
import react.RState
import react.dom.div
import shared.reachrouter.location
import shared.reachrouter.navigate

class AppFrame : RComponent<AppFrameProps, RState>() {
    override fun RBuilder.render() {
        appBar(AppBarStyle.root to props.rootStyle) {
            attrs.color = AppBarColor.default
            attrs.position = AppBarPosition.static

            toolbar(ToolbarStyle.root to props.toolbarStyle) {
                typography {
                    attrs.variant = TypographyVariant.h6

                    +"Le@rning Kotlin"
                }

                div(props.navigationsStyle) {
                    location { locationProps ->
                        listOf(home, story, learn, koans).forEach { nav ->
                            val isCurrentPage = props.pathname == nav.pathname

                            button {
                                attrs.id = nav.id
                                attrs.variant = ButtonVariant.text
                                attrs.color = if (isCurrentPage) ButtonColor.primary else ButtonColor.default
                                if (isCurrentPage) attrs["aria-current"] = "page"
                                attrs.onClickFunction = { locationProps.navigate(nav.pathname) }

                                +nav.displayName
                            }
                        }
                    }
                }
            }
        }
    }
}