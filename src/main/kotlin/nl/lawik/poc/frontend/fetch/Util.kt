package nl.lawik.poc.frontend.fetch

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.json.Json
import org.w3c.dom.Window
import org.w3c.fetch.RequestInit
import kotlin.js.Promise

/**
 * fetch extension function with deserialization handling
 *
 * @param input request url
 * @param requestInit request parameters (request method, headers, body, etc) see [RequestInit]
 * @param deserializationStrategy deserializationStrategy of the expected class,
 * class must be serializable [kotlinx.serialization.Serializable]
 *
 * @return promise of the type provided by [deserializationStrategy]
 */
fun <T> Window.fetch(
    input: dynamic,
    requestInit: RequestInit,
    deserializationStrategy: DeserializationStrategy<T>
): Promise<T> {
    return this.fetch(input, requestInit).then {
        it.text()
    }.then {
        Json.parse(deserializationStrategy, it)
    }
}