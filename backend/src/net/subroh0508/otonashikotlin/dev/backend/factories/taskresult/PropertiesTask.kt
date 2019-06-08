package net.subroh0508.otonashikotlin.dev.backend.factories.taskresult

import net.subroh0508.otonashikotlin.dev.backend.valueobjects.Task
import net.subroh0508.otonashikotlin.dev.backend.valueobjects.taskresult.OutputType
import net.subroh0508.otonashikotlin.dev.backend.valueobjects.taskresult.ResultStatus
import net.subroh0508.otonashikotlin.dev.backend.valueobjects.taskresult.TaskResult

sealed class PropertiesTask {
    abstract fun build(outputType: OutputType, output: String): TaskResult

    companion object {
        fun build(task: Task.Properties, outputType: OutputType, output: String) = TaskResult(ResultStatus.SUCCESS, "empty", "/kotori/normal.png")
    }
}