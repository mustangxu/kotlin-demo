package com.jayxu.kotlin.serialization

import kotlinx.serialization.*
import kotlinx.serialization.json.*

@Serializable
data class User(val name: String, val yearOfBirth: Int)

@Serializable
data class Project(
    val name: String,
    val owner: Account,
    val group: String = "R&D"
)

@Serializable
data class Account(val userName: String)

@Serializable
sealed class Message {
    abstract val content: String
}

@Serializable
data class BroadcastMessage(override val content: String) : Message()

@Serializable
data class DirectMessage(override val content: String, val recipient: String) : Message()

fun main() {
    // Serialization (Kotlin object to JSON string)

    val data = User("Louis", 1901)
    val string = Json.encodeToString(data)
    println(string) // {"name":"Louis","yearOfBirth":1901}

    // Deserialization (JSON string to Kotlin object)

    val obj = Json.decodeFromString<User>(string)
    println(obj) // User(name=Louis, yearOfBirth=1901)
}