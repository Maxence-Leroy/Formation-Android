package com.ragicorp.exercice1

import androidx.lifecycle.ViewModel
import com.ragicorp.data.getOrderedAnimals

class AnimalViewModel: ViewModel() {
    fun getAnimals() = getOrderedAnimals()
}