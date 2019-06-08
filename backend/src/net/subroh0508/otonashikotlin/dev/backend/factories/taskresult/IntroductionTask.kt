package net.subroh0508.otonashikotlin.dev.backend.factories.taskresult

import net.subroh0508.otonashikotlin.dev.backend.valueobjects.Task
import net.subroh0508.otonashikotlin.dev.backend.valueobjects.taskresult.OutputType
import net.subroh0508.otonashikotlin.dev.backend.valueobjects.taskresult.ResultStatus
import net.subroh0508.otonashikotlin.dev.backend.valueobjects.taskresult.TaskResult

sealed class IntroductionTask {
    abstract fun build(outputType: OutputType, output: String): TaskResult

    object DataClassesFactory : IntroductionTask() {
        override fun build(outputType: OutputType, output: String): TaskResult {
            return TaskResult(ResultStatus.SUCCESS, "empty", "/kotori/normal.png")
        }
    }

    object DefaultArgumentsFactory : IntroductionTask() {
        override fun build(outputType: OutputType, output: String): TaskResult {
            return TaskResult(ResultStatus.SUCCESS, "empty", "/kotori/normal.png")
        }
    }

    object ExtensionFunctionsFactory : IntroductionTask() {
        override fun build(outputType: OutputType, output: String): TaskResult {
            return TaskResult(ResultStatus.SUCCESS, "empty", "/kotori/normal.png")
        }
    }

    object ExtensionsOnCollectionsFactory : IntroductionTask() {
        override fun build(outputType: OutputType, output: String): TaskResult {
            return TaskResult(ResultStatus.SUCCESS, "empty", "/kotori/normal.png")
        }
    }

    object HelloWorldFactory : IntroductionTask() {
        private const val CORRECT_OUTPUT = "Hello, World!"

        private const val CORRECT_MESSAGE = "できました！最初の課題、クリアしましたよ！プロデューサーさん！"
        private const val CORRECT_SRC = "/kotori/success_1.png"

        private const val ERROR_COMPILE_MESSAGE = "動きません…。書き方を間違えちゃったみたいですね…。"
        private const val ERROR_COMPILE_SRC = "/kotori/failed_2.png"
        private const val ERROR_OUTPUT_MESSAGE = "惜しい…！後は表示させる言葉を直すだけですね。"
        private const val ERROR_OUTPUT_SRC = "/kotori/failed_1.png"

        override fun build(outputType: OutputType, output: String): TaskResult {
            if (outputType == OutputType.error) {
                return TaskResult(ResultStatus.FAILURE, ERROR_COMPILE_MESSAGE, ERROR_COMPILE_SRC)
            }

            if (output.filterNot { it == '\n' }.contains(CORRECT_OUTPUT)) {
                return TaskResult(ResultStatus.SUCCESS, CORRECT_MESSAGE, CORRECT_SRC)
            }

            return TaskResult(ResultStatus.FAILURE, ERROR_OUTPUT_MESSAGE, ERROR_OUTPUT_SRC)
        }
    }

    object LambdasFactory : IntroductionTask() {
        override fun build(outputType: OutputType, output: String): TaskResult {
            return TaskResult(ResultStatus.SUCCESS, "empty", "/kotori/normal.png")
        }
    }

    object NamedArgumentsFactory : IntroductionTask() {
        override fun build(outputType: OutputType, output: String): TaskResult {
            return TaskResult(ResultStatus.SUCCESS, "empty", "/kotori/normal.png")
        }
    }

    object NullableTypesFactory : IntroductionTask() {
        override fun build(outputType: OutputType, output: String): TaskResult {
            return TaskResult(ResultStatus.SUCCESS, "empty", "/kotori/normal.png")
        }
    }

    object ObjectExpressionsFactory : IntroductionTask() {
        override fun build(outputType: OutputType, output: String): TaskResult {
            return TaskResult(ResultStatus.SUCCESS, "empty", "/kotori/normal.png")
        }
    }

    object SAMConversionsFactory : IntroductionTask() {
        override fun build(outputType: OutputType, output: String): TaskResult {
            return TaskResult(ResultStatus.SUCCESS, "empty", "/kotori/normal.png")
        }
    }

    object SmartCastsFactory : IntroductionTask() {
        override fun build(outputType: OutputType, output: String): TaskResult {
            return TaskResult(ResultStatus.SUCCESS, "empty", "/kotori/normal.png")
        }
    }

    companion object {
        fun build(task: Task.Introduction, outputType: OutputType, output: String): TaskResult = when (task) {
            Task.Introduction.DATA_CLASSES-> DataClassesFactory.build(outputType, output)
            Task.Introduction.DEFAULT_ARGUMENTS-> DefaultArgumentsFactory.build(outputType, output)
            Task.Introduction.EXTENSION_FUNCTIONS-> ExtensionFunctionsFactory.build(outputType, output)
            Task.Introduction.EXTENSIONS_ON_COLLECTIONS-> ExtensionsOnCollectionsFactory.build(outputType, output)
            Task.Introduction.HELLO_WORLD-> HelloWorldFactory.build(outputType, output)
            Task.Introduction.LAMBDAS-> LambdasFactory.build(outputType, output)
            Task.Introduction.NAMED_ARGUMENTS-> NamedArgumentsFactory.build(outputType, output)
            Task.Introduction.NULLABLE_TYPES-> NullableTypesFactory.build(outputType, output)
            Task.Introduction.OBJECT_EXPRESSIONS-> ObjectExpressionsFactory.build(outputType, output)
            Task.Introduction.SAM_CONVERSIONS-> SAMConversionsFactory.build(outputType, output)
            Task.Introduction.SMART_CASTS-> SmartCastsFactory.build(outputType, output)
        }
    }
}
