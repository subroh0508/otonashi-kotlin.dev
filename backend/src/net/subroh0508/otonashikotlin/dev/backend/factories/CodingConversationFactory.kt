package net.subroh0508.otonashikotlin.dev.backend.factories

import net.subroh0508.otonashikotlin.dev.backend.factories.codingconversation.*
import net.subroh0508.otonashikotlin.dev.backend.parameters.KoansParameter
import net.subroh0508.otonashikotlin.dev.backend.valueobjects.Task

object CodingConversationFactory {
    fun build(params: KoansParameter<*>, code: String?) = when (params.task) {
        is Task.Builders -> BuildersTask.build(params.task, code)
        is Task.Collections -> CollectionsTask.build(params.task, code)
        is Task.Conventions -> ConventionsTask.build(params.task, code)
        is Task.Generics -> GenericsTask.build(params.task, code)
        is Task.Introduction -> IntroductionTask.build(params.task, code)
        is Task.Properties -> PropertiesTask.build(params.task, code)
        else -> throw IllegalStateException()
    }
}