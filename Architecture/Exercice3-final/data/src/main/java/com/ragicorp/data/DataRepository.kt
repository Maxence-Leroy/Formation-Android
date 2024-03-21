package com.ragicorp.data

fun getOrderedAnimals() = getAnimals().sortedBy { it.id }