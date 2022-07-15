package com.jayxu.kotlin.aquar

interface FishAction {
    fun eat()
}

class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}

interface FishColor {
    val color: String
}

class Plecostomus(fishColor: FishColor = GoldColor) : FishAction by PrintingFishAction(
    "eat algae"
),
    FishColor by fishColor {

    init {
        println("Plecostomus initializing")
    }
}

class Shark : FishAction,
    FishColor {
    override val color = "gray"
    override fun eat() {
        println("hunt and eat fish")
    }
}

interface AquariumAction {
    fun eat()
    fun jump()
    fun clean()
    fun catchFish()
    fun swim() {
        println("swim")
    }
}

object GoldColor : FishColor {
    override val color = "gold"
}

sealed class Seal
class SeaLion : Seal()
class Walrus : Seal()

fun matchSeal(seal: Seal): String {
    return when (seal) {
        is Walrus -> "walrus"
        is SeaLion -> "sea lion"
    }
}
