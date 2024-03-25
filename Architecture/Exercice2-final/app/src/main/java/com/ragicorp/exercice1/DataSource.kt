package com.ragicorp.exercice1

import com.google.gson.Gson

class DataSource {
    fun getAnimals(): List<Animal> {
        val gson = Gson()
        val animals = gson.fromJson(apiResult, Array<Animal>::class.java)
        return animals.toList()
    }
}