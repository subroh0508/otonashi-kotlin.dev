package net.subroh0508.otonashikotlin.dev.backend.valueobjects.taskresult

data class TaskResult(
    val status: ResultStatus,
    val message: String,
    val avatar: String
)