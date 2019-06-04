package shared

import io.ktor.client.HttpClient
import io.ktor.client.engine.js.Js

val client = HttpClient(Js) {

}
