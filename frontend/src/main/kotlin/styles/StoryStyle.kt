package styles

import kotlinx.css.*
import kotlinx.css.properties.LineHeight
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.border
import kotlinx.css.properties.boxShadow
import materialui.styles.StylesSet

val storyStyle: StylesSet.() -> Unit = {
    "content" {
        height = 768.px
        paddingTop = 24.px
        paddingBottom = 0.px
        textAlign = TextAlign.center

        children("iframe") {
            height = 720.px
            width = 1280.px
        }
    }
    "messageBox" {
        width = 640.px
        height = 320.px
        top = 0.px
        bottom = 0.px
        left = 0.px
        right = 0.px
        margin(LinearDimension.auto)
        position = Position.absolute

        "&& .msgbox" {
            margin(0.px, 0.px, 20.px)
            borderRadius = 20.px
            boxShadow(rgba(1, 1, 1, 0.4), offsetX = 0.px, offsetY = 0.px, blurRadius = 15.px)
        }
        "&& .msgboxtop" {
            height = 50.px
            background = "linear-gradient(#fbe988, #c5b36b)"
            color = Color("#333333")
            padding(8.px, 10.px)
            fontSize = 24.px
            fontWeight = FontWeight.bold
            borderTopLeftRadius = 20.px
            borderTopRightRadius = 20.px

            before {
                content = "\\28FF\\0020".quoted
                marginRight = 15.px
            }
        }
        "&& .msgboxbody" {
            height = 160.px
            background = "white"
            fontSize = 18.px
            padding(7.px, 14.px)

            descendants("img") {
                width = 80.px
                height = 80.px
                float = Float.left
                margin(15.px, 20.px, 15.px, 30.px)
            }

            descendants(".itemname") {
                lineHeight = LineHeight("110px")
            }

            descendants(".red") {
                marginLeft = 12.px
                color = Color.deepPink
            }

            descendants(".notice") {
                descendants(".material-icons") {
                    verticalAlign = VerticalAlign.bottom
                }

                textAlign = TextAlign.center
                color = Color.deepPink
            }
        }
        "&& .msgboxfoot" {
            background = "lightgray"
            padding(15.px, 40.px, 18.px)
            borderBottomLeftRadius = 20.px
            borderBottomRightRadius = 20.px
            textAlign = TextAlign.center
            minHeight = 25.px
        }
        "&& .button" {
            boxSizing = BoxSizing.borderBox
            position = Position.relative
            background = "linear-gradient(80deg, #f9f9f9, #e1edf5)"
            padding(4.px, 40.px)
            margin(5.px)
            declarations["color"] = "black !important"
            textDecoration = TextDecoration.none
            borderRadius = 50.px
            border(1.px, BorderStyle.solid, Color.black)
            boxShadow(Color.darkGray, 0.px, 0.px, 0.px, 2.px)
            fontSize = 24.px
            fontWeight = FontWeight.bold
            overflow = Overflow.auto

            hover {
                background = "lightgray"
            }

            active {
                background = "gray"
            }
        }
    }
}