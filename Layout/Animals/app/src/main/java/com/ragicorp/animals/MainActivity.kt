package com.ragicorp.animals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ragicorp.animals.AnimalDetail.animalDetailNavigationEntry
import com.ragicorp.animals.AnimalDetail.navigateToAnimalDetail
import com.ragicorp.animals.ui.theme.AnimalsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimalsTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = AnimalsList.Route
                ) {
                    composable(AnimalsList.Route) {
                        AnimalsList.Screen(
                            navigateToAnimalDetail = { navController.navigateToAnimalDetail(it) }
                        )
                    }

                    animalDetailNavigationEntry(
                        navigateBack = { navController.popBackStack() }
                    )
                }
            }
        }
    }
}
