package shared.components.kotlinplayground

import kotlinext.js.jsObject
import kotlinx.html.AttributeEnum
import kotlinx.html.DIV
import kotlinx.html.Tag
import kotlinx.html.TagConsumer
import org.w3c.dom.Node
import react.RBuilder
import react.dom.RDOMBuilder

@JsModule("kotlin-playground")
private external val playground: (String, KotlinPlaygroundOption) -> dynamic = definedExternally

fun createPlayground(
    selector: String,
    option: KotlinPlaygroundOption.() -> Unit = {}
) = playground(selector, (jsObject<KotlinPlaygroundOption> {}).apply(option))

class KotlinPlaygroundBuilder<T: Tag>(
    factory: (TagConsumer<Unit>) -> T
) : RDOMBuilder<T>(factory) {
    var Tag.dataVersion: String?
        get() = this["data-version"] as String?
        set(value) { value?.let { this["data-version"] = it } }
    var Tag.args: Array<out String>
        get() = (this["args"] as String? ?: "").split(" ").toTypedArray()
        set(value) { this["args"] = value.joinToString(" ") }
    fun Tag.args(vararg args: String) { this.args = args }
    var Tag.dataTargetPlatform: Platform?
        get() = (this["data-target-platform"] as String?)?.let { Platform.valueOf(it) }
        set(value) { this["data-target-platform"] = value.toString() }
    var Tag.dataHighlightOnly: Boolean
        get() = this["data-highlight-only"] as Boolean? ?: false
        set(value) { this["data-highlight-only"] = value }
    var Tag.autoIndent: Boolean
        get() = this["auto-indent"] as Boolean? ?: false
        set(value) { this["auto-indent"] = value }
    var Tag.foldedButton: Boolean
        get() = this["folded-button"] as Boolean? ?: false
        set(value) { this["folded-button"] = value }
    var Tag.theme: Theme?
        get() = (this["theme"] as String?)?.let { Theme.valueOf(it) }
        set(value) { this["theme"] = value.toString() }
    var Tag.mode: Mode?
        get() = (this["mode"] as String?)?.let { Mode.valueOf(it) }
        set(value) { value?.let { this["mode"] = it.realValue } }
    var Tag.highlightOnFly: Boolean
        get() = this["highlight-on-fly"] as Boolean? ?: false
        set(value) { this["highlight-on-fly"] = value.toString() }
    var Tag.indent: Int
        get() = this["indent"] as Int? ?: 4
        set(value) { this["indent"] = value }
    var Tag.lines: Boolean
        get() = this["lines"] as Boolean? ?: false
        set(value) { this["lines"] = value.toString() }
    var Tag.from: Int?
        get() = this["from"] as Int?
        set(value) { value?.let { this["from"] = it } }
    var Tag.to: Int?
        get() = this["to"] as Int?
        set(value) { value?.let { this["to"] = it } }
    fun Tag.range(from: Int, to: Int) {
        this.from = from
        this.to = to
    }
    var Tag.matchBracket: Boolean
        get() = this["match-bracket"] as Boolean? ?: false
        set(value) { this["match-bracket"] = value }
    fun code(
        sample: Boolean = false,
        block: () -> String
    ) {
        if (sample) { +"//sampleStart" }
        +(block().trimIndent())
        if (sample) { +"//sampleEnd" }
    }
}

@Suppress("EntryEnumName")
enum class Platform {
    junit, canvas, js, java
}

enum class Theme {
    idea, darcula, default
}

enum class Mode(override val realValue: String) : AttributeEnum {
    kotlin("kotlin"),
    js("js"),
    java("java"),
    groovy("groovy"),
    xml("xml"),
    c("c"),
    shell("shell"),
    swift("swift"),
    objC("obj-c")
}

inline fun RBuilder.kotlinCode(
    className: String = "kotlin-code",
    block: KotlinPlaygroundBuilder<DIV>.() -> Unit
) = child(KotlinPlaygroundBuilder { DIV(mapOf("class" to className), it) }.apply(block).create())

external interface KotlinPlaygroundOption {
    var server: String
    var onChange: ((String) -> Unit)?
    var onTestPassed: (() -> Unit)?
    var onTestFailed: (() -> Unit)?
    var onRun: (() -> Unit)?
    var onCloseConsole: (() -> Unit)?
    var onOpenConsole: (() -> Unit)?
    var callback: (Node, Node) -> Unit
    var getInstance: (KotlinPlaygroundInstance) -> Unit
}

external interface KotlinPlaygroundInstance {
    var state: KotlinPlaygroundState
}

external interface KotlinPlaygroundState {
    var theme: String
    var code: String
    var foldButtonHover: Boolean
    var folded: Boolean
    var output: String?
}

fun KotlinPlaygroundOption.getState(callback: (KotlinPlaygroundState) -> Unit) {
    getInstance = { callback.invoke(it.state) }
}
