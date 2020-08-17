package zone.nora.basicallylouis.gson

import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.google.gson.reflect.TypeToken
import okhttp3.OkHttpClient
import okhttp3.Request
import java.lang.reflect.Type

val gson = Gson()

fun parse(jsonString: String): JsonElement = JsonParser().parse(jsonString)

fun parseAsObj(jsonString: String): JsonObject = parse(jsonString).asJsonObject

fun getContent(rest: String): String {
    val client = OkHttpClient()
    val request = Request.Builder()
        .url(rest)
        .get()
        .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 5.1; rv:19.0) Gecko/20100101 Firefox/19.0")
        .build()
    val response = client.newCall(request).execute()
    return response.body()!!.string()
}

inline fun <reified T> typeToken() = object: TypeToken<T>() {}.type