package com.ragicorp.animals

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

object AnimalsList {
    const val Route = "list"

    @Composable
    fun Screen(
        navigateToAnimalDetail: (Int) -> Unit
    ) {
        val animals = getAnimals()
        Surface(modifier = Modifier.fillMaxSize()) {
            LazyColumn {
                items(animals) {
                    AnimalItem(animal = it, navigateToAnimalDetail = navigateToAnimalDetail)
                }
            }
        }
    }
}

@Composable
private fun AnimalItem(animal: Animal, navigateToAnimalDetail: (Int) -> Unit) {
    Surface(
        modifier = Modifier.padding(8.dp).width(64.dp),
        onClick = {navigateToAnimalDetail(animal.id)},
        color = MaterialTheme.colorScheme.primary
    ) {
        Text(text = animal.name, textAlign = TextAlign.Center)
    }
}