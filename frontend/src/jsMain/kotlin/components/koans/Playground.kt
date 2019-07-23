package components.koans

import kotlinext.js.jsObject
import materialui.styles.childWithStyles
import org.w3c.dom.MutationObserver
import org.w3c.dom.MutationRecord
import org.w3c.dom.Node
import org.w3c.dom.get
import react.RBuilder
import react.RComponent
import react.RState
import react.dom.div
import shared.components.kotlinplayground.Platform
import shared.components.kotlinplayground.createPlayground
import shared.components.kotlinplayground.kotlinCode
import styles.playgroundStyle
import kotlin.browser.window

class Playground : RComponent<PlaygroundProps, RState>() {
    private val observer = MutationObserver(this::onChangeOutput)

    override fun componentDidMount() = createPlayground()

    override fun componentDidUpdate(prevProps: PlaygroundProps, prevState: RState, snapshot: Any) = createPlayground()

    override fun componentWillUnmount() {
        observer.disconnect()
    }

    override fun shouldComponentUpdate(nextProps: PlaygroundProps, nextState: RState): Boolean {
        return window.document.getElementsByClassName("executable-fragment-wrapper").length == 0
                || props.initialCode != nextProps.initialCode
    }

    private fun createPlayground() {
        createPlayground(".kotlin-code") {
            onOpenConsole = { this@Playground.onOpenConsole() }
            onCloseConsole = { this@Playground.onCloseConsole() }
            onTestPassed = props.onTestPassed
            onTestFailed = props.onTestFailed
            onChange = props.onChange
        }
    }

    private fun onOpenConsole() {
        observer.observe(
            window.document.getElementsByClassName("js-code-output-executor")[0] as Node,
            jsObject { childList = true }
        )
        props.onOpenConsole?.invoke()
    }

    private fun onCloseConsole() {
        observer.disconnect()
        props.onCloseConsole?.invoke()
    }

    private fun onChangeOutput(records: Array<MutationRecord>, observer: MutationObserver) {
        val codeOutput = records.last().addedNodes[0]?.childNodes?.get(0) ?: return

        if (codeOutput.asDynamic()?.attributes?.`class`?.value != "code-output") {
            return
        }

        val resultNode = codeOutput.childNodes[0]
        val className = (resultNode.asDynamic()?.attributes?.`class`?.value as? String) ?: ""
        when {
            className.startsWith("standard-output") ->
                props.onReceivedMessage?.invoke(Message.output, resultNode?.childNodes?.get(0)?.textContent ?: "")
            className.startsWith("console-block") ->
                props.onReceivedMessage?.invoke(Message.error, resultNode?.childNodes?.get(3)?.textContent ?: "")
        }
    }

    private fun RBuilder.root(render: RBuilder.(PlaygroundImplProps) -> Unit)
            = (childWithStyles<PlaygroundImplProps>("PlaygroundImpl", playgroundStyle) {
                props -> div(props.rootStyle) { render(props) }
            }) {}

    override fun RBuilder.render() {
        root {
            kotlinCode {
                attrs.dataVersion = "1.3.31"
                attrs.lines = true
                attrs.dataTargetPlatform = Platform.java

                /*
                code {
                    """
                    import org.junit.Test
                    import org.junit.Assert

                    class TestIO() {
                        @Test fun testHello() {
                            Assert.assertEquals("Hello, World!", hello())
                        }
                    }

                    //sampleStart
                    fun hello() = [mark]TODO()[/mark]
                    //sampleEnd
                    """
                }
                */

                code { props.initialCode }
            }
        }
    }
}