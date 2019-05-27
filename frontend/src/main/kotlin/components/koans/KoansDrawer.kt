package components.koans

import kotlinext.js.jsObject
import materialui.components.divider.divider
import materialui.components.drawer.drawer
import materialui.components.drawer.enums.DrawerAnchor
import materialui.components.drawer.enums.DrawerStyle
import materialui.components.drawer.enums.DrawerVariant
import materialui.components.hidden.hidden
import materialui.components.list.list
import materialui.components.listitem.listItem
import materialui.components.listitemtext.listItemText
import materialui.styles.childWithStyles
import react.RBuilder
import react.buildElement
import react.dom.div
import react.dom.key
import react.dom.nav
import styles.drawerStyle

val RBuilder.KoansDrawer get() = childWithStyles<KoansDrawerProps>("KoansDrawer", drawerStyle) { props ->
    val drawerList = buildElement {
        div {
            list {
                arrayOf("Section 1-1", "Section 1-2", "Section 1-3").forEachIndexed { index, s ->
                    listItem(button = true) {
                        attrs.key = s

                        listItemText {
                            attrs.primary { +s }
                        }
                    }
                }
            }

            divider { }

            list {
                arrayOf("Section 2-1", "Section 2-2", "Section 2-3").forEachIndexed { index, s ->
                    listItem(button = true) {
                        attrs.key = s

                        listItemText {
                            attrs.primary { +s }
                        }
                    }
                }
            }
        }
    }

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
}