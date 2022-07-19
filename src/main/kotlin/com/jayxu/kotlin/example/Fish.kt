package com.jayxu.kotlin.example

data class Fish(var name: String)

fun fishExamples() {
    val fish = Fish("splashy")  // all lowercase
    myWith(fish.name) {
        println(capitalize())
    }

    fish.run {
        name
    }

    val fish2 = Fish(name = "splashy").apply {
        name = "sharky"
    }
    println(fish2.name)

    println(fish.let { it.name.capitalize() }
        .let { it + "fish" }
        .let { it.length }
        .let { it + 31 })
}

inline fun myWith(name: String, block: String.() -> Unit) {
    name.block()
}

fun runExample() {
    JavaRun.runNow {
        println("Passing a lambda as a Runnable")
    }
}

fun main() {
    fishExamples()
    runExample()
}