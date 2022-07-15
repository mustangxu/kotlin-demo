package com.jayxu.kotlin.generics

open class WaterSupply(var needsProcessing: Boolean)

class TapWater : WaterSupply(true) {
    fun addChemicalCleaners() {
        needsProcessing = false
    }
}

class FishStoreWater : WaterSupply(false)

class LakeWater : WaterSupply(true) {
    fun filter() {
        needsProcessing = false
    }
}

class Aquarium<out T : WaterSupply>(val waterSupply: T) {
    fun addWater(cleaner: Cleaner<T>) {
        if (waterSupply.needsProcessing) {
            cleaner.clean(waterSupply)
        }
        println("water added")
    }

    inline fun <reified R : WaterSupply> hasWaterSupplyOfType() = waterSupply is R
}

interface Cleaner<in T : WaterSupply> {
    fun clean(waterSupply: T)
}

fun genericsExample() {
    val cleaner = TapWaterCleaner()
    val aquarium = Aquarium<TapWater>(TapWater())
    println("water needs processing: ${aquarium.waterSupply.needsProcessing}")
    aquarium.addWater(cleaner)
    addItemTo(aquarium)

    aquarium.waterSupply.addChemicalCleaners()
    println("water needs processing: ${aquarium.waterSupply.needsProcessing}")

    println(aquarium.hasWaterSupplyOfType<TapWater>())

//    val aquarium2 = Aquarium("string")
//    println(aquarium2.waterSupply)

//    val aquarium3 = Aquarium(null)
//    if (aquarium3.waterSupply == null) {
//        println("waterSupply is null")
//    }
}

fun main() {
    genericsExample()
}

fun addItemTo(aquarium: Aquarium<WaterSupply>) = println("item added")

class TapWaterCleaner : Cleaner<TapWater> {
    override fun clean(waterSupply: TapWater) = waterSupply.addChemicalCleaners()
}

fun isWaterClean(aquarium: Aquarium<WaterSupply>) {
    println("aquarium water is clean: ${!aquarium.waterSupply.needsProcessing}")
}