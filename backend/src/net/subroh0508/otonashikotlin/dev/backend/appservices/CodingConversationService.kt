package net.subroh0508.otonashikotlin.dev.backend.appservices

import net.subroh0508.otonashikotlin.dev.backend.factories.CodingConversationFactory
import net.subroh0508.otonashikotlin.dev.backend.parameters.KoansParameter
import net.subroh0508.otonashikotlin.dev.backend.valueobjects.condingconversation.CodingConversation

object CodingConversationService {
    fun build(section: String, task: String, code: String?): CodingConversation {
        val parameter = KoansParameter.newInstance(section, task)

        return CodingConversationFactory.build(parameter, code)
    }
}