package nl.lawik.poc.frontend.fetch

import org.w3c.fetch.RequestInit
import kotlin.browser.window
import kotlinx.serialization.*
import kotlinx.serialization.json.Json
import kotlin.js.Promise
import kotlin.js.json

private const val API_URL = "https://jsonplaceholder.typicode.com/todos"

fun main() {
    fetchGET().then { println(it) }
    fetchPOST().then { println(it) }
    fetchPUT().then { println(it) }
    fetchDELETE()
}

fun fetchGET(): Promise<List<Todo>> {
    return window.fetch(
        API_URL,
        RequestInit(method = "GET"),
        Todo.serializer().list
    )
}

fun fetchPOST(): Promise<Todo> {
    return window.fetch(
        API_URL,
        RequestInit(
            method = "POST",
            body = Json(encodeDefaults = false).stringify(Todo.serializer(), Todo(1, "test", false)),
            headers = json("Content-Type" to "application/json")
        ),
        Todo.serializer()
    )
}

fun fetchPUT(): Promise<Todo> {
    return window.fetch(
        "$API_URL/1",
        RequestInit(
            method = "PUT",
            body = Json.stringify(Todo.serializer(), Todo(1, "test2", true, 1)),
            headers = json("Content-Type" to "application/json")
        ),
        Todo.serializer()
    )
}

fun fetchDELETE(): Promise<Unit> {
    return window.fetch(
        "$API_URL/1",
        RequestInit(method = "DELETE")
    ).then {
        println("Todo deleted")
    }
}

