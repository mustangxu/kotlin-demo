package com.jayxu.kotlin.ext

fun String.hasSpaces() = find { it == ' ' } != null
