package com.jayxu.kotlin.coreroutine

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    launch {
        val a = 3
        delay(300)
        println(a)
    }
    launch {
        val b = 2
        delay(200)
        println(b)
    }
    launch {
        val c = 1
        delay(100)
        // breakpoint here:
        println(c)
    }
}