package components.koans

import materialui.components.typography.enums.TypographyVariant
import materialui.components.typography.typography
import materialui.styles.childWithStyles
import react.RBuilder
import react.dom.div
import styles.koansStyle

val RBuilder.Koans get() = childWithStyles<KoansProps>("Koans", koansStyle) { props ->
    div(props.rootStyle) {
        KoansDrawer {
            attrs.mobileMenuOpen = props.mobileMenuOpen
            attrs.onClose = props.onDrawerClose
        }
        div {
            typography {
                attrs.variant = TypographyVariant.h2

                +"Koans"
            }
        }
    }
}
