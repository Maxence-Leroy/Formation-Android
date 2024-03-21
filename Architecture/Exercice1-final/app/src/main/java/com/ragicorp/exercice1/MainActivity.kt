package com.ragicorp.exercice1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.ragicorp.exercice1.ui.theme.Exercice1Theme

data class Animal(
    val id: Int,
    val name: String
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = AnimalViewModel()
        val animals = viewModel.getAnimals()
        
        setContent {
            Exercice1Theme {
                LazyColumn {
                    items(animals) {
                        AnimalView(animal = it)
                    }
                }
            }
        }
    }
}

@Composable
fun AnimalView(animal: Animal) {
    Text(animal.name)
}
