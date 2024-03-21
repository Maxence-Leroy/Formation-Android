package com.ragicorp.exercice1

import androidx.lifecycle.ViewModel

class AnimalViewModel: ViewModel() {
    fun getAnimals() = getOrderedAnimals()
}