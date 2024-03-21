package com.ragicorp.exercice1

import com.google.gson.Gson

fun getAnimals(): List<Animal> {
    val gson = Gson()
    val animals = gson.fromJson(apiResult, Array<Animal>::class.java)
    return animals.toList()
}