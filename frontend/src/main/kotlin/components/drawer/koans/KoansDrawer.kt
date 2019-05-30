package components.drawer.koans

import components.koans.sections.introduction
import kotlinext.js.jsObject
import kotlinx.html.NAV
import kotlinx.html.js.onClickFunction
import materialui.components.collapse.collapse
import materialui.components.drawer.drawer
import materialui.components.drawer.enums.DrawerAnchor
import materialui.components.drawer.enums.DrawerStyle
import materialui.components.drawer.enums.DrawerVariant
import materialui.components.hidden.hidden
import materialui.components.list.list
import materialui.components.listitem.buttonListItem
import materialui.components.listitemtext.listItemText
import materialui.styles.childWithStyles
import react.RBuilder
import react.buildElement
import react.dom.div
import react.dom.nav
import react.rFunction
import shared.reachrouter.navigate
import styles.drawerStyle
import kotlin.browser.window

val RBuilder.KoansDrawer get() = rFunction<KoansDrawerProps>("KoansDrawer") {
    (childWithStyles<KoansDrawerProps>("KoansDrawerImpl", drawerStyle) { props ->
        val drawerList = buildElement {
            div { renderSections(props) }
        }

        div(classes = props.rootStyle) {
            nav(classes = props.navStyle) {
                hidden {
                    attrs {
                        implementation = "css"
                        smUp = true
                    }

                    drawer(DrawerStyle.paper to props.paperStyle) {
                        attrs.variant = DrawerVariant.temporary
                        attrs.anchor = DrawerAnchor.left
                        attrs.open = props.mobileMenuOpen
                        attrs.onClose = props.onClose
                        attrs.ModalProps = jsObject { asDynamic()["keepMounted"] = true }

                        drawerList?.let(this::child)
                    }
                }
                hidden {
                    attrs {
                        implementation = "css"
                        xsDown = true
                    }

                    drawer(DrawerStyle.paper to props.paperStyle) {
                        attrs.variant = DrawerVariant.permanent
                        attrs.open = true

                        drawerList?.let(this::child)
                    }
                }
            }

            props.children()
        }
    }) {
        attrs.mobileMenuOpen = it.mobileMenuOpen

        it.children()
    }
}

fun RBuilder.renderSections(props: KoansDrawerProps) {
    list(factory = { NAV(mapOf(), it) }) {
        buttonListItem {
            attrs.onClickFunction = {
                navigate("/koans/${introduction.pathname}")
            }

            listItemText { attrs.primary { +introduction.displayName } }
        }
    }

    collapse {
        attrs.`in` = window.location.href.contains("koans/Introduction")
        attrs.unmountOnExit = true

        introduction.children.forEach { section ->
            buttonListItem {
                attrs.onClickFunction = {
                    navigate("/koans/${introduction.pathname}/${section.pathname}")
                }

                listItemText { attrs.primary { +section.displayName } }
            }
        }
    }
}



