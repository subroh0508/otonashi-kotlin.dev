package shared.components.revealjs

import kotlinx.html.id
import kotlinx.html.p
import kotlinx.html.section
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.iframe
import shared.components.millionBalloon

class RevealJsComponent : RComponent<RProps, RState>() {
    override fun componentDidMount() {
        revealBuilder("reveal-frame") {
            section {
                attributes["data-background-image"] = "/background/IMG_1298.PNG"
                attributes["data-background-size"] = "contain"

                millionBalloon("小鳥") {
                    p("fragment fade-in script-content") { +"プロデューサーさん！　お疲れ様です！" }
                    p("fragment fade-in script-content") { +"社長がお呼びでしたよ。" }
                }
            }
            section {
                attributes["data-background-image"] = "/background/IMG_1299.PNG"
                attributes["data-background-size"] = "contain"

                millionBalloon("にしこりP") {
                    p("fragment fade-in script-content") { +"了解です。" }
                    p("fragment fade-in script-content") { +"(何の話だろうか、心当たりがないな…)" }
                }
            }
            section {
                +"こんな感じのコミュが書きたい！！！！！！！！"
            }
        }
    }

    override fun RBuilder.render() {
        iframe { attrs.id = "reveal-frame" }
    }
}
