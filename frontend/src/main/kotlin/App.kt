
import components.appframe.AppFrame
import materialui.components.cssbaseline.cssBaseline
import materialui.components.typography.enums.TypographyVariant
import materialui.components.typography.typography
import materialui.styles.childWithStyles
import materialui.styles.muithemeprovider.muiThemeProvider
import react.*
import react.dom.div
import shared.reachrouter.Router
import shared.reachrouter.RoutingProps
import shared.reachrouter.location
import styles.appFrameStyle
import themes.appTheme

class App : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        cssBaseline {  }
        muiThemeProvider(appTheme) {
            location { props ->
                childWithStyles(AppFrame::class, appFrameStyle) {
                    attrs.pathname = props.location.pathname.replace("^/(.+)$".toRegex()) { it.groupValues[1] }
                }

                Router {
                    attrs.location = props.location

                    home { attrs.path = "/" }
                    story { attrs.path = "story" }
                    learning { attrs.path = "learn" }
                    koans { attrs.path = "koans" }
                }
            }
        }
    }
}

val home = rFunction<RoutingProps>("Home") {
    div { typography { attrs.variant = TypographyVariant.h1; +"Home" } }
}

val story = rFunction<RoutingProps>("Dashboard") {
    div { typography { attrs.variant = TypographyVariant.h1; +"Story" } }
}

val learning = rFunction<RoutingProps>("Learn") {
    div { typography { attrs.variant = TypographyVariant.h1; +"Learn" } }
}

val koans = rFunction<RoutingProps>("koans") {
    div { typography { attrs.variant = TypographyVariant.h1; +"Koans" } }
}
