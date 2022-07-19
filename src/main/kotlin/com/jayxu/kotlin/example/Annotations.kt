package com.jayxu.kotlin.example

import kotlin.reflect.full.*

annotation class ImAPlant
@Target(AnnotationTarget.PROPERTY_GETTER)
annotation class OnGet
@Target(AnnotationTarget.PROPERTY_SETTER)
annotation class OnSet

@ImAPlant class Plant {
    fun trim(){}
    fun fertilize(){}

    @get:OnGet
    val isGrowing: Boolean = true

    @set:OnSet
    var needsFood: Boolean = false
}

fun testAnnotations() {
    val classObj = Plant::class
    for (m in classObj.declaredMemberFunctions) {
        println(m.name)
    }

    for (a in classObj.annotations) {
        println(a.annotationClass.simpleName)
    }

    val myAnnotationObject = classObj.findAnnotation<ImAPlant>()
    println(myAnnotationObject)
}

fun labels() {
    outerLoop@ for (i in 1..100) {
        print("$i ")
        for (j in 1..100) {
            if (i > 10) break@outerLoop  // breaks to outer loop
        }
    }
}

fun main() {
    testAnnotations()
    labels()
}