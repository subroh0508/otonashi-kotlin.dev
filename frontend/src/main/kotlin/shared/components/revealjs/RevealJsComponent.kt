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

                        +"社長、おはようございます！"
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
                attributes["data-background-image"] = "/clip/02.png"
                attributes["data-background-size"] = "contain"

                millionBalloon("小鳥") {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"あ、そうでしたね！"
                    }
                    p("fragment script-content") {
                        +"データ、もう上がってきてますか？"
                    }
                }
            }

            section {
                attributes["data-background-image"] = "/clip/02.png"
                attributes["data-background-size"] = "contain"

                millionBalloon("高木社長", withTakagi = true) {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"今確認するぞ！"
                    }
                    p("fragment script-content") {
                        +"おー、来てる来てる！　良い、実に良いサイトだ！"
                    }
                }
            }

            section {
                attributes["data-background-video"] = "/clip/03.mp4"
                attributes["data-background-size"] = "contain"

                millionBalloon("小鳥") {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"本当ですか！　私にも見せてください！"
                    }
                    p("fragment script-content") {
                        +"…えっ、これが、完成品…？？？"
                    }
                }
            }

            section {
                millionBalloon("　") {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"ガチャッ"
                    }
                    p("fragment script-content") {

                    }
                }
            }

            section {
                millionBalloon("プロデューサー") {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"社長、音無さん、おはようございます！"
                    }
                    p("fragment script-content") {
                        +"あれ、音無さん、どうかしましたか？"
                    }
                }
            }

            section {
                attributes["data-background-video"] = "/clip/04.mp4"
                attributes["data-background-size"] = "contain"

                millionBalloon("小鳥") {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"プロデューサーさん、出来上がったコーポレートサイトなんですが、"
                    }
                    p("fragment script-content") {
                        +"これを、見ていただけますか…？"
                    }
                }
            }

            section {
                attributes["data-background-image"] = "/clip/04.png"
                attributes["data-background-size"] = "contain"

                millionBalloon("プロデューサー") {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"あ、入稿日今日でしたね！"
                    }
                    p("fragment script-content") {
                        +"もちろん見ます！　どれどれ…"
                    }
                }
            }

            section {
                attributes["data-background-image"] = "/clip/abehiroshi01.png"
                attributes["data-background-size"] = "contain"

                millionBalloon("プロデューサー") {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"…なっ、これは！？　一時期Web業界を震撼させた、全ての無駄が省かれた"
                    }
                    p("fragment script-content") {
                        +"人類史上最速・最軽量の、あの男性俳優の…！！！"
                    }
                }
            }

            section {
                attributes["data-background-video"] = "/clip/abehiroshi01.mp4"
                attributes["data-background-size"] = "contain"

                millionBalloon("高木社長", withTakagi = true) {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"おお、君、よく知ってるじゃあないか！"
                    }
                    p("fragment script-content") {
                        +"Webサイトにおいて、速度と処理の軽さはやっぱり大事だよねえ！"
                    }
                }
            }

            section {
                attributes["data-background-image"] = "/clip/abehiroshi02.png"
                attributes["data-background-size"] = "contain"

                millionBalloon("高木社長", withTakagi = true) {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"参考にしたサイト、俳優の名前は誰だったかなぁ。"
                    }
                    p("fragment script-content") {
                        +"えーと、阿部…"
                    }
                }
            }

            section {
                attributes["data-background-image"] = "/clip/abehiroshi02.png"
                attributes["data-background-size"] = "contain"

                millionBalloon("プロデューサー") {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"だあああああああ！！！　知ってます社長！"
                    }
                    p("fragment script-content") {
                        +"某寛のことは知ってますから、大丈夫です！！！"
                    }
                }
            }

            section {
                attributes["data-background-video"] = "/clip/06.mp4"
                attributes["data-background-size"] = "contain"

                millionBalloon("小鳥") {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"どうですかプロデューサーさん。これ、非常事態、ですよね？"
                    }
                    p("fragment script-content") {

                    }
                }
            }

            section {
                attributes["data-background-image"] = "/clip/06.png"
                attributes["data-background-size"] = "contain"

                millionBalloon("プロデューサー") {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"はい、音無さん。これは、間違いなく非常事態です。"
                    }
                    p("fragment script-content") {
                        +"リリース予定日、いつでしたっけ？"
                    }
                }
            }

            section {
                attributes["data-background-video"] = "/clip/07.mp4"
                attributes["data-background-size"] = "contain"

                millionBalloon("小鳥") {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"…3日後です。"
                    }
                    p("fragment script-content") {

                    }
                }
            }

            section {
                attributes["data-background-video"] = "/clip/08.mp4"
                attributes["data-background-size"] = "contain"

                millionBalloon("プロデューサー") {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"ですよね。そう、なったら、分かりました。僕が作りましょう！"
                    }
                    p("fragment script-content") {
                        +"前職はエンジニアやってました。3日あれば、多分ギリギリ…！"
                    }
                }
            }

            section {
                attributes["data-background-video"] = "/clip/09.mp4"
                attributes["data-background-size"] = "contain"

                millionBalloon("小鳥") {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"えええ！！！　だ、大丈夫ですか、プロデューサーさん！？"
                    }
                    p("fragment script-content") {
                        +"私、ITよくわからないですけど、それって3日徹夜とかじゃ…？"
                    }
                }
            }

            section {
                attributes["data-background-image"] = "/clip/09.png"
                attributes["data-background-size"] = "contain"

                millionBalloon("プロデューサー") {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"アイドルたちのためなら、なんてことはないです！"
                    }
                    p("fragment script-content") {
                        +"使える素材、集めといてください！　僕、家からPC取ってきます！"
                    }
                }
            }

            section {
                attributes["data-background-video"] = "/clip/10.mp4"
                attributes["data-background-size"] = "contain"

                millionBalloon("小鳥") {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"ちょ、ちょっとプロデューサーさん！？"
                    }
                    p("fragment script-content") {
                        +"もう行っちゃった。本当に、大丈夫かしら…？"
                    }
                }
            }

            section {
                attributes["data-background-video"] = "/clip/01.mp4"
                attributes["data-background-size"] = "contain"

                millionBalloon("　") {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"3日後..."
                    }
                    p("fragment script-content") {

                    }
                }
            }

            section {
                millionBalloon("　") {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"ガチャッ！"
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

                        +"プロデューサーさん！　新しいサイト、見ましたよ！"
                    }
                    p("fragment script-content") {
                        +"すごいです！　完璧です！　これならお仕事もたくさん…"
                    }
                }
            }

            section {
                attributes["data-background-image"] = "/clip/02.png"
                attributes["data-background-size"] = "contain"

                millionBalloon("プロデューサー") {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"( ˘ω˘) z z Z Z"
                    }
                    p("fragment script-content") {

                    }
                }
            }

            section {
                attributes["data-background-video"] = "/clip/03.mp4"
                attributes["data-background-size"] = "contain"

                millionBalloon("小鳥") {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"…！　おやすみ、でしたね。"
                    }
                    p("fragment script-content") {
                        +"PC開きっぱなし寝ちゃうなんて、本当にお疲れ様です。"
                    }
                }
            }

            section {
                attributes["data-background-video"] = "/clip/12-01.mp4"
                attributes["data-background-size"] = "contain"

                millionBalloon("小鳥") {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"(エンジニアの方って、普段こんなソフト使って仕事するのね…。"
                    }
                    p("fragment script-content") {

                        +"英語がたくさん…！　これがプログラミング言語、でいいのかしら？"
                    }
                }
            }

            section {
                attributes["data-background-video"] = "/clip/12-02.mp4"
                attributes["data-background-size"] = "contain"

                millionBalloon("小鳥") {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"…「Programming Language Kotlin」？　なんだかかわいい名前。"
                    }
                    p("fragment script-content") {

                        +"「Kotlinを愛でる」「Kotlinはかわいい」「かわいい、かわいいよKotlin」"
                    }
                }
            }

            section {
                attributes["data-background-video"] = "/clip/12-03.mp4"
                attributes["data-background-size"] = "contain"

                millionBalloon("小鳥") {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"な、何だか見てるこっちがそわそわしちゃうわね…"
                    }
                    p("fragment script-content") {

                        +"…ん？？？　ちょっと待って、待つのよ、小鳥…！"
                    }
                }
            }

            section {
                attributes["data-background-video"] = "/clip/12-04.mp4"
                attributes["data-background-size"] = "contain"

                millionBalloon("小鳥") {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"プロデューサーさん、前職はKotlinを使ってお仕事を…？？？"
                    }
                    p("fragment script-content") {

                        +"ということは、「Kotlinはかわいい」って言いながらお仕事を…？？？"
                    }
                }
            }

            section {
                attributes["data-background-video"] = "/clip/12-05.mp4"
                attributes["data-background-size"] = "contain"

                millionBalloon("小鳥") {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"だとしたら、これは最早事務所の同僚を超えた、赤い糸で結ばれた関係！"
                    }
                    p("fragment script-content") {

                        +"運命よ、運命に違いないわ！)"
                    }
                }
            }

            section {
                millionBalloon("プロデューサー") {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"…う、うええ…、頭いたい…"
                    }
                    p("fragment script-content") {
                        +"あ、おはようございます、音無さん…"
                    }
                }
            }

            section {
                attributes["data-background-video"] = "/clip/13.mp4"
                attributes["data-background-size"] = "contain"

                millionBalloon("小鳥") {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"ピ、ピヨーーー！！！"
                    }
                    p("fragment script-content") {

                    }
                }
            }

            section {
                attributes["data-background-image"] = "/clip/13.png"
                attributes["data-background-size"] = "contain"

                millionBalloon("プロデューサー") {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"うわあああ！！！"
                    }
                    p("fragment script-content") {
                        +"す、すいません、驚かしてしまって…"
                    }
                }
            }

            section {
                attributes["data-background-video"] = "/clip/14-01.mp4"
                attributes["data-background-size"] = "contain"

                millionBalloon("小鳥") {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"い、いえ、大丈夫です。そんなことより、プロデューサーさん。"
                    }
                    p("fragment script-content") {
                        +"私に、Kotlinを教えてください！"
                    }
                }
            }

            section {
                attributes["data-background-image"] = "/clip/14-01.png"
                attributes["data-background-size"] = "contain"

                millionBalloon("プロデューサー") {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"…えっ？？？　どうしたんですか、急に？？？"
                    }
                    p("fragment script-content") {
                        +"前職で使っていたんで、確かに教えられますけど…。"
                    }
                }
            }

            section {
                attributes["data-background-video"] = "/clip/14-02.mp4"
                attributes["data-background-size"] = "contain"

                millionBalloon("小鳥") {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"いえ、何てことはないんですけど、その、大変な時に"
                    }
                    p("fragment script-content") {
                        +"何もお手伝いできなかったのが申し訳なくて…"
                    }
                }
            }

            section {
                attributes["data-background-video"] = "/clip/16.mp4"
                attributes["data-background-size"] = "contain"

                millionBalloon("小鳥") {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"プログラミングができるようになったら、もっと"
                    }
                    p("fragment script-content") {
                        +"アイドルのみんなのためにお仕事できるかなって、思ったんです。"
                    }
                }
            }

            section {
                attributes["data-background-video"] = "/clip/17.mp4"
                attributes["data-background-size"] = "contain"

                millionBalloon("小鳥") {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"(そうよ小鳥、まずはここから。距離を縮めるのよ。"
                    }
                    p("fragment script-content") {
                        +"折角やってきた運命の出会い、手繰りよせるわよ！）"
                    }
                }
            }

            section {
                attributes["data-background-image"] = "/clip/17.png"
                attributes["data-background-size"] = "contain"

                millionBalloon("プロデューサー") {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"(な、なんだかよくわからないけど、すごいやる気だ…！"
                    }
                    p("fragment script-content") {
                        +"確かに、プログラミングできる人がいたら僕も嬉しいし…）"
                    }
                }
            }

            section {
                attributes["data-background-image"] = "/clip/17.png"
                attributes["data-background-size"] = "contain"

                millionBalloon("プロデューサー") {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"わかりました、教えましょう！"
                    }
                    p("fragment script-content") {
                        +"Kotlinについて、僕の知っている限りのこと、全部！"
                    }
                }
            }

            section {
                attributes["data-background-video"] = "/clip/18.mp4"
                attributes["data-background-size"] = "contain"

                millionBalloon("小鳥") {
                    p("fragment script-content") {
                        attributes["data-autoslide"] = "1000"

                        +"…！　ありがとうございます！　プロデューサーさん！"
                    }
                    p("fragment script-content") {
                        +"私、精一杯頑張りますから、これからよろしくお願いしますね！"
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
