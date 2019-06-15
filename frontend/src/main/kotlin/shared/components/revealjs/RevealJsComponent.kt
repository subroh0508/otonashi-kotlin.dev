package shared.components.revealjs

import kotlinx.html.id
import kotlinx.html.p
import kotlinx.html.section
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.iframe

class RevealJsComponent : RComponent<RProps, RState>() {
    override fun componentDidMount() {
        revealBuilder("reveal-frame") {
            section {
                p { +"小鳥" }
                p("fragment fade-in") { +"プロデューサーさん！　お疲れ様です！" }
                p("fragment fade-in") { +"社長がお呼びでしたよ。" }
            }
            section {
                p { +"プロデューサー" }
                p("fragment fade-in") { +"了解です。" }
                p("fragment fade-in") { +"(何の話だろうか、心当たりがないな…)" }
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
