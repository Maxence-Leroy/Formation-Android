package com.ragicorp.animals

data class Animal(val id: Int, val name: String, val action: String)

fun getAnimals() = listOf(
    Animal(0, "Cow", "Moo"),
    Animal(1, "Dog", "Bark"),
    Animal(2, "Cat", "Purr")
)