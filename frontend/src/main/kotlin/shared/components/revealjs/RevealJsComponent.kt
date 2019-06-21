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
import kotlin.collections.set

class RevealJsComponent : RComponent<RProps, RState>() {
    override fun componentDidMount() {
        revealBuilder("reveal-frame") {
            section {
                attributes["data-background-video"] = "/clip/01.mp4"
                attributes["data-background-size"] = "contain"

                millionBalloon("　") {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"ある日..."
                    }
                    p("fragment script-content") {

                    }
                }
            }
            section {
                attributes["data-background-video"] = "/clip/02.mp4"
                attributes["data-background-size"] = "contain"

                millionBalloon("小鳥") {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"おはようございます、社長！"
                    }
                    p("fragment script-content") {

                    }
                }
            }

            section {
                attributes["data-background-image"] = "/clip/02.png"
                attributes["data-background-size"] = "contain"

                millionBalloon("高木社長", withTakagi = true) {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"おはよう！　音無君！"
                    }
                    p("fragment script-content") {
                        +"そう言えば今日は、新しいコーポレートサイトの入稿日だったね？"
                    }
                }
            }

            section {
                attributes["data-background-video"] = "/clip/04.mp4"
                attributes["data-background-size"] = "contain"

                millionBalloon("小鳥") {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"プロデューサーさん！　お疲れ様です！"
                    }
                    p("fragment script-content") {
                        +"社長がお呼びでしたよ。"
                    }
                }
            }
            section {
                attributes["data-background-video"] = "/clip/06.mp4"
                attributes["data-background-size"] = "contain"

                millionBalloon("プロデューサー") {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"了解です。"
                    }
                    p("fragment script-content") {
                        +"(何の話だろうか、心当たりがないな…)"
                    }
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
