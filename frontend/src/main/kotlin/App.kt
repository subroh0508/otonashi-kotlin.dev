
import components.appframe.AppFrame
import materialui.components.cssbaseline.cssBaseline
import materialui.styles.childWithStyles
import materialui.styles.themeprovider.themeProvider
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import styles.appFrameStyle
import themes.appTheme

class App : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        cssBaseline {  }
        themeProvider(appTheme) {
            childWithStyles(AppFrame::class, appFrameStyle) {  }
        }
    }
}
