package components.koans

import components.koans.sections.Section
import components.koans.sections.introduction
import materialui.components.typography.enums.TypographyVariant
import materialui.components.typography.typography
import react.RBuilder
import react.dom.div
import react.rFunction
import shared.reachrouter.RoutingProps

fun RBuilder.koans() {
    sectionView(introduction) { task ->
        child<TaskProps, Task> {
            attrs.task = task
        }
    }
}

fun RBuilder.sectionView(section: Section, render: RBuilder.(Section) -> Unit) {
    val sectionRClass = rFunction<RoutingProps>(section.displayName) { it.children() }

    sectionRClass {
        attrs.path = section.pathname

        section.children.forEach { task ->
            val childRClass = rFunction<RoutingProps>("Playground") { render.invoke(this, task) }
            childRClass { attrs.path = task.pathname }
        }

        val defaultRClass = rFunction<RoutingProps>("default") {
            div { typography { attrs.variant = TypographyVariant.h1; +"Default" } }
        }
        defaultRClass { attrs.default = true }
    }
}
