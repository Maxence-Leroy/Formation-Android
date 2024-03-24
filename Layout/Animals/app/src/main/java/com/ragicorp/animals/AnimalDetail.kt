package com.ragicorp.animals

import android.os.Bundle
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

object AnimalDetail {
    private const val RouteBase = "animalDetail"
    private const val AnimalArgument = "animalId"
    private const val Route = "$RouteBase?$AnimalArgument={$AnimalArgument}"

    // Wrapper for type-safety
    fun NavGraphBuilder.animalDetailNavigationEntry(
        navigateBack: () -> Unit,
    ) {
        composable(
            Route,
            arguments = listOf(
                navArgument(AnimalArgument) {
                    type = NavType.IntType
                },
            )
        ) {
            val args: Bundle = it.arguments ?: throw IllegalArgumentException()
            val animalId = args.getInt(AnimalArgument)
            Screen(
                animalId = animalId,
                navigateBack = navigateBack
            )
        }
    }


    // Wrapper for type-safety
    fun NavHostController.navigateToAnimalDetail(
        animalId: Int,
    ) {
        navigate("$RouteBase?$AnimalArgument=$animalId")
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun Screen(
        animalId: Int,
        navigateBack: () -> Unit,
    ) {
        val animal = getAnimals().firstOrNull { it.id == animalId }
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(animal?.name ?: "Unknown animal") },
                    navigationIcon = {
                        IconButton(onClick = navigateBack) {
                            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                        }
                    }
                )
            },
            content = {
                Surface(modifier = Modifier.padding(it)) {
                    if (animal != null)
                        Text("The ${animal.name} ${animal.action}s")
                    else
                        Text("Unknown animal")
                }
            }
        )
    }
}