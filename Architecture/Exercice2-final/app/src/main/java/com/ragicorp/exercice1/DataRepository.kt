package com.ragicorp.exercice1

class DataRepository {
    private val dataSource = DataSource()
    fun getOrderedAnimals() = dataSource.getAnimals().sortedBy { it.id }
}
