package net.subroh0508.otonashikotlin.dev.backend.factories

import net.subroh0508.otonashikotlin.dev.backend.factories.taskresult.*
import net.subroh0508.otonashikotlin.dev.backend.parameters.KoansParameter
import net.subroh0508.otonashikotlin.dev.backend.valueobjects.Task

object TaskResultFactory {
    fun build(params: KoansParameter<*>, output: String) = when (params.task) {
        is Task.Builders -> BuildersTask.build(params.task, params.outputType, output)
        is Task.Collections -> CollectionsTask.build(params.task, params.outputType, output)
        is Task.Conventions -> ConventionsTask.build(params.task, params.outputType, output)
        is Task.Generics -> GenericsTask.build(params.task, params.outputType, output)
        is Task.Introduction -> IntroductionTask.build(params.task, params.outputType, output)
        is Task.Properties -> PropertiesTask.build(params.task, params.outputType, output)
        else -> throw IllegalStateException()
    }
}