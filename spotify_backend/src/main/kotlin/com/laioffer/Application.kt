package com.laioffer

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json

@Serializable
data class Playlist (
    val id: Long,
    val songs: List<Song>
)

@Serializable
data class Song (
    val name: String,
    val lyric: String,
    val src: String,
    val length: String
)


fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
        })
    }
    // TODO: adding the routing configuration here
    // /feed, /playlists, /playlist/1, 0:8080/songs/solo.mp3
    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        get("feed") {
            val jsonString: String? = this::class.java.classLoader.getResource("feed.json")?.readText()
            call.respondText(jsonString ?: "null")
        }

        get("playlists") {
            val jsonString = this::class.java.classLoader.getResource("playlists.json")?.readText()
            call.respondText(jsonString ?: "null")
        }

        get("playlist/{id}") {

//            val jsonString: String? = this::class.java.classLoader.getResource("playlists.json")?.readText()
//
//            if (jsonString != null ) {
//                // jsonString -> List<Playlist> -> loop and filter
//                val playlists: List<Playlist> = Json.decodeFromString(ListSerializer(Playlist.serializer()), jsonString)
//                val id = call.parameters["id"]
//
//                val playlist: Playlist? = playlists.firstOrNull { item -> item.id.toString() == id }
//                call.respondNullable(playlist)
//            } else {
//                call.respondText("null")
//            }

            // jsonString -> List<Playlist>
            // jsonString -> kotlin/java object: decode/deserialize
            // kotlin/java object -> jsonString: Serialize
//            val jsonString: String? = this::class.java.classLoader.getResource("playlists.json")?.readText()
            this::class.java.classLoader.getResource("playlists.json")?.readText()?.let {
                val playlists = Json.decodeFromString(ListSerializer(Playlist.serializer()), it)
                // id
                val id = call.parameters["id"]
                val playlist: Playlist? = playlists.firstOrNull { item: Playlist -> item.id.toString() == id }
                call.respondNullable(playlist)
            } ?: call.respondText("null")
        }

        static("/") {
            staticBasePackage = "static"
            static("songs") {
                resources("songs")
            }
        }
    }

    myRouting {
        myGet("/") {
            println("hello world")
        }
    }

    val a: String? = "a"

    if (a != null) {
        println(a)
    } else {
        println("null")
    }

    // let { }
    a?.let {
        println(it)
    } ?: println("null")
}

// Unit == void
fun myRouting(configuration: () -> Unit) {
    configuration()
}

fun myGet(path: String, body: () -> Unit) {

}