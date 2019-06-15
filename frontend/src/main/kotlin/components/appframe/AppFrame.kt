package components.appframe

import components.drawer.koans.koansDrawer
import components.koans.koansTask
import kotlinx.html.id
import kotlinx.html.js.onClickFunction
import materialui.components.appbar.appBar
import materialui.components.appbar.enums.AppBarColor
import materialui.components.appbar.enums.AppBarPosition
import materialui.components.appbar.enums.AppBarStyle
import materialui.components.button.button
import materialui.components.button.enums.ButtonColor
import materialui.components.button.enums.ButtonVariant
import materialui.components.icon.icon
import materialui.components.iconbutton.enums.IconButtonStyle
import materialui.components.iconbutton.iconButton
import materialui.components.toolbar.enums.ToolbarStyle
import materialui.components.toolbar.toolbar
import materialui.components.typography.enums.TypographyVariant
import materialui.components.typography.typography
import react.RBuilder
import react.RComponent
import react.dom.div
import react.rFunction
import react.setState
import shared.components.reachrouter.Router
import shared.components.reachrouter.RoutingProps
import shared.components.reachrouter.navigate
import kotlin.browser.window

class AppFrame : RComponent<AppFrameProps, AppFrameState>() {
    override fun AppFrameState.init() {
        currentPage = initPage()
        mobileMenuOpen = false
    }

    private fun initPage(): Navigation = listOf(story, learn, koans).find { nav ->
        """^http://localhost:8088/${nav.pathname}.*$""".toRegex().matches(
            window.location.href
        )
    } ?: home

    private fun onMenuButtonClick() {
        setState { mobileMenuOpen = !state.mobileMenuOpen && state.currentPage.hasDrawer }
    }

    private fun onMenuClose() {
        setState { mobileMenuOpen = false }
    }

    private fun onNavButtonClick(nav: Navigation) {
        navigate("/${nav.pathname}")

        setState {
            currentPage = nav
            mobileMenuOpen = false
        }
    }

    override fun RBuilder.render() {
        appBar(AppBarStyle.root to props.rootStyle) {
            attrs.color = AppBarColor.default
            attrs.position = AppBarPosition.relative

            toolbar(ToolbarStyle.root to props.toolbarStyle) {
                if (state.currentPage.hasDrawer) {
                    iconButton(IconButtonStyle.root to props.menuButtonStyle) {
                        attrs.color = ButtonColor.inherit
                        attrs.onClickFunction = { onMenuButtonClick() }

                        icon { +"menu_icon" }
                    }
                }

                typography {
                    attrs.variant = TypographyVariant.h6

                    +"Le@rning Kotlin"
                }

                div(props.navigationsStyle) {
                    listOf(story, learn, koans).forEach { nav ->
                        val isCurrentPage = state.currentPage.pathname == nav.pathname

                        button {
                            attrs.id = nav.id
                            attrs.variant = ButtonVariant.text
                            attrs.color = if (isCurrentPage) ButtonColor.primary else ButtonColor.default
                            if (isCurrentPage) attrs["aria-current"] = "page"
                            attrs.onClickFunction = { onNavButtonClick(nav) }

                            +nav.displayName
                        }
                    }
                }
            }
        }

        Router {
            storyView { attrs.path = "story" }
            learningView { attrs.path = "learn" }
            koansDrawer { sections ->
                attrs.path = koans.pathname
                attrs.mobileMenuOpen = state.mobileMenuOpen

                sections.forEach { koansTask(it) }
            }
        }
    }
}

val storyView = rFunction<RoutingProps>("Dashboard") {
    div { typography { attrs.variant = TypographyVariant.h1; +"Story" } }
}

val learningView = rFunction<RoutingProps>("Learn") {
    div { typography { attrs.variant = TypographyVariant.h1; +"Learn" } }
}
