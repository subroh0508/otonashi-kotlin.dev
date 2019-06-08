package net.subroh0508.otonashikotlin.dev.backend.parameters

import net.subroh0508.otonashikotlin.dev.backend.valueobjects.Task
import net.subroh0508.otonashikotlin.dev.backend.valueobjects.taskresult.OutputType

class KoansParameter<T: Task>(
    val task: T
) {
    companion object {
        fun newInstance(section: String, task: String)
            = when (section) {
                "Builders" -> KoansParameter(
                    Task.Builders.values().find { it.pathname == task } ?: throw IllegalStateException()
                )
                "Collections" -> KoansParameter(
                    Task.Collections.values().find { it.pathname == task } ?: throw IllegalStateException()
                )
                "Conventions" -> KoansParameter(
                    Task.Conventions.values().find { it.pathname == task } ?: throw IllegalStateException()
                )
                "Generics" -> KoansParameter(
                    Task.Generics.values().find { it.pathname == task } ?: throw IllegalStateException()
                )
                "Introduction" -> KoansParameter(
                    Task.Introduction.values().find { it.pathname == task } ?: throw IllegalStateException()
                )
                "Properties" -> KoansParameter(
                    Task.Properties.values().find { it.pathname == task } ?: throw IllegalStateException()
                )
                else -> throw IllegalStateException()
            }

        fun newInstance(section: String, task: String, status: String)
                = TaskResultParameter(newInstance(section, task), OutputType.valueOf(status))
    }
}