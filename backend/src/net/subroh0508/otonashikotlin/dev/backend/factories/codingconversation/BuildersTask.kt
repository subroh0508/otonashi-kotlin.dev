package net.subroh0508.otonashikotlin.dev.backend.factories.codingconversation

import net.subroh0508.otonashikotlin.dev.backend.valueobjects.Task
import net.subroh0508.otonashikotlin.dev.backend.valueobjects.condingconversation.CodingConversation

sealed class BuildersTask {
    abstract fun build(code: String?): CodingConversation

    companion object {
        fun build(task: Task.Builders, code: String?) = CodingConversation("empty", "/kotori/normal.png")
    }
}
