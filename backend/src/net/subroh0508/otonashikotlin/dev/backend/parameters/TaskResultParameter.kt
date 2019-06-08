package net.subroh0508.otonashikotlin.dev.backend.parameters

import net.subroh0508.otonashikotlin.dev.backend.valueobjects.Task
import net.subroh0508.otonashikotlin.dev.backend.valueobjects.taskresult.OutputType

data class TaskResultParameter<T: Task>(
    private val params: KoansParameter<T>,
    val outputType: OutputType
) {
    val task: T = params.task
}