package net.subroh0508.otonashikotlin.dev.backend.parameters

import net.subroh0508.otonashikotlin.dev.backend.valueobjects.Task
import net.subroh0508.otonashikotlin.dev.backend.valueobjects.taskresult.OutputType

class KoansParameter<T: Task>(
    val task: T,
    val outputType: OutputType
) {
    companion object {
        fun newInstance(section: String, task: String, status: String)
            = when (section) {
                "Builders" -> KoansParameter(
                    Task.Builders.values().find { it.pathname == task } ?: throw IllegalStateException(),
                    OutputType.valueOf(status)
                )
                "Collections" -> KoansParameter(
                    Task.Collections.values().find { it.pathname == task } ?: throw IllegalStateException(),
                    OutputType.valueOf(status)
                )
                "Conventions" -> KoansParameter(
                    Task.Conventions.values().find { it.pathname == task } ?: throw IllegalStateException(),
                    OutputType.valueOf(status)
                )
                "Generics" -> KoansParameter(
                    Task.Generics.values().find { it.pathname == task } ?: throw IllegalStateException(),
                    OutputType.valueOf(status)
                )
                "Introduction" -> KoansParameter(
                    Task.Introduction.values().find { it.pathname == task } ?: throw IllegalStateException(),
                    OutputType.valueOf(status)
                )
                "Properties" -> KoansParameter(
                    Task.Properties.values().find { it.pathname == task } ?: throw IllegalStateException(),
                    OutputType.valueOf(status)
                )
                else -> throw IllegalStateException()
            }
    }
}