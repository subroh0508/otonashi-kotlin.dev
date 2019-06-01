package components.koans

import components.koans.sections.Section
import components.koans.sections.introduction
import materialui.components.typography.enums.TypographyVariant
import materialui.components.typography.typography
import react.RBuilder
import react.dom.div
import react.rFunction
import shared.reachrouter.RoutingProps
import shared.reachrouter.componentWithPath

fun RBuilder.koans() {
    sectionView(introduction) { task ->
        div { typography { attrs.variant = TypographyVariant.h1; +task.displayName } }
    }
}

fun RBuilder.sectionView(section: Section, render: RBuilder.(Section) -> Unit)
        = (componentWithPath<RoutingProps>(section.displayName)) {
            attrs.path = section.pathname

            section.children.forEach { task ->
                (rFunction<RoutingProps>(task.pathname) {
                    render.invoke(this, task)
                }) { attrs.path = task.pathname }
            }
            (rFunction<RoutingProps>("default") {
                div { typography { attrs.variant = TypographyVariant.h1; +"Default" } }
            }) { attrs.default = true }
        }
