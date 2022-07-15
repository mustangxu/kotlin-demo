package com.jayxu.kotlin.ext

fun main() {
    println("Does it have spaces?".hasSpaces())

    val plant = GreenLeafyPlant(size = 10)
    plant.print()
    println("\n")
    val aquariumPlant: AquariumPlant? = null
    aquariumPlant?.print()  // what will it print?
}
