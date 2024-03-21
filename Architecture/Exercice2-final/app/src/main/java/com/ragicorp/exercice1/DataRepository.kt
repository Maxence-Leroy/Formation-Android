package com.ragicorp.exercice1

fun getOrderedAnimals() = getAnimals().sortedBy { it.id }