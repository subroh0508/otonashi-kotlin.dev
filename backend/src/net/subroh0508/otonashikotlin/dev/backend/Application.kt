@file:UseExperimental(KtorExperimentalLocationsAPI::class)

package net.subroh0508.otonashikotlin.dev.backend

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CORS
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.locations.Location
import io.ktor.locations.Locations
import io.ktor.locations.get
import io.ktor.response.respond
import io.ktor.routing.route
import io.ktor.routing.routing
import net.subroh0508.otonashikotlin.dev.backend.appservices.CodingConversationService
import net.subroh0508.otonashikotlin.dev.backend.appservices.TaskResultService

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(CORS) {
        method(HttpMethod.Options)
        method(HttpMethod.Put)
        method(HttpMethod.Delete)
        method(HttpMethod.Patch)
        header(HttpHeaders.Authorization)
        header("MyCustomHeader")
        allowCredentials = true
        host("localhost:8088")
    }
    install(ContentNegotiation) {
        gson { serializeNulls() }
    }
    install(Locations) { }

    routing {
        route("/api/v1") {
            @Location("/{section}/{task}/task_results")
            data class TaskResultsParams(val section: String, val task: String, val output: String, val status: String)
            get<TaskResultsParams> { params ->
                val result = TaskResultService.validate(
                    params.section,
                    params.task,
                    params.status,
                    params.output
                )

                call.respond(HttpStatusCode.OK, result)
            }

            @Location("/{section}/{task}/start_conversations")
            data class StartConversationsParams(val section: String, val task: String)
            get<StartConversationsParams> { params ->
                val conversation = CodingConversationService.build(params.section, params.task, null)

                call.respond(HttpStatusCode.OK, conversation)
            }

            @Location("/{section}/{task}/coding_conversations")
            data class CodingConversationsParams(val section: String, val task: String, val code: String?)
            get<CodingConversationsParams> { params ->
                val conversation = CodingConversationService.build(params.section, params.task, params.code)

                call.respond(HttpStatusCode.OK, conversation)
            }
        }
    }
}
