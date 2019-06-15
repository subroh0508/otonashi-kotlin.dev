package components.drawer.koans

import components.koans.sections.Section
import kotlinext.js.jsObject
import kotlinx.css.FontWeight
import kotlinx.html.NAV
import kotlinx.html.js.onClickFunction
import materialui.components.collapse.collapse
import materialui.components.divider.divider
import materialui.components.divider.enums.DividerStyle
import materialui.components.drawer.drawer
import materialui.components.drawer.enums.DrawerAnchor
import materialui.components.drawer.enums.DrawerStyle
import materialui.components.drawer.enums.DrawerVariant
import materialui.components.hidden.hidden
import materialui.components.icon.enums.IconColor
import materialui.components.icon.icon
import materialui.components.list.list
import materialui.components.listitem.buttonListItem
import materialui.components.listitemicon.listItemIcon
import materialui.components.listitemtext.listItemText
import materialui.styles.childWithStyles
import react.RBuilder
import react.RElementBuilder
import react.buildElement
import react.dom.div
import react.dom.nav
import shared.components.reachrouter.navigate
import styled.styledSpan
import styles.drawerStyle
import kotlin.browser.window

private val sections: Array<Section> = arrayOf(
    kotlinext.js.require("sections/Introduction.json"),
    kotlinext.js.require("sections/Conventions.json"),
    kotlinext.js.require("sections/Collections.json"),
    kotlinext.js.require("sections/Properties.json"),
    kotlinext.js.require("sections/Builders.json"),
    kotlinext.js.require("sections/Generics.json")
)

fun RBuilder.koansDrawer(block: RElementBuilder<KoansDrawerProps>.(Array<Section>) -> Unit) {
    KoansDrawerImpl { block.invoke(this, sections) }
}

private val RBuilder.KoansDrawerImpl get() = childWithStyles<KoansDrawerProps>("KoansDrawer", drawerStyle) { props ->
    val drawerList = buildElement {
        div { renderSections(props, sections) }
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
}

fun RBuilder.renderSections(props: KoansDrawerProps, sections: Array<Section>) {
    fun collapseIn(pathname: String) = window.location.href.contains("koans/$pathname")
    fun nowTask(section: String, task: String) = window.location.href.contains("koans/$section/$task")

    list(factory = { NAV(mapOf(), it) }) {
        sections.forEach { section ->
            buttonListItem {
                attrs.onClickFunction = {
                    navigate("/koans/${section.pathname}")
                }

                listItemText { attrs.primary { +section.displayName } }
            }

            divider {}

            collapse {
                attrs.`in` = collapseIn(section.pathname)
                attrs.unmountOnExit = true

                section.tasks.forEach { task ->
                    buttonListItem {
                        attrs.onClickFunction = {
                            navigate("/koans/${section.pathname}/${task.pathname}")
                        }

                        val nowTask = nowTask(section.pathname, task.pathname)
                        listItemIcon(props.listItemIconStyle) {
                            if (nowTask) {
                                icon {
                                    attrs.color = IconColor.primary

                                    +"arrow_right_alt"
                                }
                            }
                        }
                        listItemText {
                            attrs.primary {
                                styledSpan {
                                    if (nowTask) {
                                        css.fontWeight = FontWeight.bold
                                    }

                                    +task.displayName
                                }
                            }
                        }
                    }

                    divider(DividerStyle.root to props.listItemDividerStyle) {}
                }
            }
        }
    }
}



