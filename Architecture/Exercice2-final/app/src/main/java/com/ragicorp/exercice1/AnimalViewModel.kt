package com.ragicorp.exercice1

import androidx.lifecycle.ViewModel

class AnimalViewModel: ViewModel() {
    private val repository = DataRepository()
    fun getAnimals() = repository.getOrderedAnimals()
}