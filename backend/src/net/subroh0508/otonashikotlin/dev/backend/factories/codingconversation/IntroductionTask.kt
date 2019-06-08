package net.subroh0508.otonashikotlin.dev.backend.factories.codingconversation

import net.subroh0508.otonashikotlin.dev.backend.valueobjects.Task
import net.subroh0508.otonashikotlin.dev.backend.valueobjects.condingconversation.CodingConversation

sealed class IntroductionTask {
    abstract fun build(code: String?): CodingConversation

    object DataClassesFactory : IntroductionTask() {
        override fun build(code: String?): CodingConversation {
            return CodingConversation("empty", "/kotori/normal.png")
        }
    }

    object DefaultArgumentsFactory : IntroductionTask() {
        override fun build(code: String?): CodingConversation {
            return CodingConversation("empty", "/kotori/normal.png")
        }
    }

    object ExtensionFunctionsFactory : IntroductionTask() {
        override fun build(code: String?): CodingConversation {
            return CodingConversation("empty", "/kotori/normal.png")
        }
    }

    object ExtensionsOnCollectionsFactory : IntroductionTask() {
        override fun build(code: String?): CodingConversation {
            return CodingConversation("empty", "/kotori/normal.png")
        }
    }

    object HelloWorldFactory : IntroductionTask() {
        private val codeRegex = """
            fun main\(\) \{
            (.*)
            }
        """.trimIndent().toRegex()

        private const val INIT_MESSAGE = "最初の課題は、「『Hello, World!』を画面に表示させよう！」ですか…。何事もまずは挨拶から、ってことかしら…？"
        private const val INIT_SRC = "/kotori/normal.png"

        private const val THINKING_MESSAGE = "えっと、ここをこうして…"
        private const val THINKING_SRC = "/kotori/motivated_1.png"

        private const val HINT_REPLACE_TODO_MESSAGES = "『TODO()』って書いてあるところを直すんですね、やってみます！"
        private const val HINT_REPLACE_TODO_SRC = "/kotori/motivated_1.png"

        private const val HINT_USE_PRINT_MESSAGES = "文字の表示は『print(...)』や『println(...)』を使う、みたいです！"
        private const val HINT_USE_PRINT_SRC = "/kotori/motivated_1.png"

        override fun build(code: String?): CodingConversation {
            if (code == null) {
                return CodingConversation(INIT_MESSAGE, INIT_SRC)
            }

            val mainScope = codeRegex.find(code)?.value ?: return CodingConversation(
                HINT_USE_PRINT_MESSAGES, HINT_USE_PRINT_SRC
            )

            if (mainScope.contains("TODO")) {
                return CodingConversation(HINT_REPLACE_TODO_MESSAGES, HINT_REPLACE_TODO_SRC)
            }

            return CodingConversation(THINKING_MESSAGE, THINKING_SRC)
        }
    }

    object LambdasFactory : IntroductionTask() {
        override fun build(code: String?): CodingConversation {
            return CodingConversation("empty", "/kotori/normal.png")
        }
    }

    object NamedArgumentsFactory : IntroductionTask() {
        override fun build(code: String?): CodingConversation {
            return CodingConversation("empty", "/kotori/normal.png")
        }
    }

    object NullableTypesFactory : IntroductionTask() {
        override fun build(code: String?): CodingConversation {
            return CodingConversation("empty", "/kotori/normal.png")
        }
    }

    object ObjectExpressionsFactory : IntroductionTask() {
        override fun build(code: String?): CodingConversation {
            return CodingConversation("empty", "/kotori/normal.png")
        }
    }

    object SAMConversionsFactory : IntroductionTask() {
        override fun build(code: String?): CodingConversation {
            return CodingConversation("empty", "/kotori/normal.png")
        }
    }

    object SmartCastsFactory : IntroductionTask() {
        override fun build(code: String?): CodingConversation {
            return CodingConversation("empty", "/kotori/normal.png")
        }
    }

    companion object {
        fun build(task: Task.Introduction, code: String?): CodingConversation = when (task) {
            Task.Introduction.DATA_CLASSES-> DataClassesFactory.build(code)
            Task.Introduction.DEFAULT_ARGUMENTS-> DefaultArgumentsFactory.build(code)
            Task.Introduction.EXTENSION_FUNCTIONS-> ExtensionFunctionsFactory.build(code)
            Task.Introduction.EXTENSIONS_ON_COLLECTIONS-> ExtensionsOnCollectionsFactory.build(code)
            Task.Introduction.HELLO_WORLD-> HelloWorldFactory.build(code)
            Task.Introduction.LAMBDAS-> LambdasFactory.build(code)
            Task.Introduction.NAMED_ARGUMENTS-> NamedArgumentsFactory.build(code)
            Task.Introduction.NULLABLE_TYPES-> NullableTypesFactory.build(code)
            Task.Introduction.OBJECT_EXPRESSIONS-> ObjectExpressionsFactory.build(code)
            Task.Introduction.SAM_CONVERSIONS-> SAMConversionsFactory.build(code)
            Task.Introduction.SMART_CASTS-> SmartCastsFactory.build(code)
        }
    }
}
