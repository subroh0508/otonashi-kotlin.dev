package net.subroh0508.otonashikotlin.dev.backend.appservices

import net.subroh0508.otonashikotlin.dev.backend.factories.TaskResultFactory
import net.subroh0508.otonashikotlin.dev.backend.parameters.KoansParameter
import net.subroh0508.otonashikotlin.dev.backend.valueobjects.taskresult.TaskResult

object TaskResultService {
    fun validate(section: String, task: String, status: String, output: String): TaskResult {
        val parameter = KoansParameter.newInstance(section, task, status)

        return TaskResultFactory.build(parameter, output)
    }
}