package com.ragicorp.exercice1

import androidx.lifecycle.ViewModel

class AnimalViewModel: ViewModel() {
    private val animals = listOf(
        Animal(1, "Dog"),
        Animal(2, "Cat"),
        Animal(3, "Pig"),
        Animal(4, "Duck"),
        Animal(5, "Cow")
    )

    fun getAnimals() = animals
}