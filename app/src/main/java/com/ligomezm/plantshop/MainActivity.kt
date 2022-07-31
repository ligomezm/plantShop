package com.ligomezm.plantshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ligomezm.plantshop.ui.components.Plants
import com.ligomezm.plantshop.ui.screens.DetailScreen
import com.ligomezm.plantshop.ui.screens.FeedScreen
import com.ligomezm.plantshop.ui.theme.PlantShopTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationHost()
        }
    }
}

@Composable
fun NavigationHost() {
    val navController = rememberNavController()
    PlantShopTheme() {
        Surface(color = MaterialTheme.colors.background) {
            NavHost(navController = navController, startDestination = "feed") {
                composable(route = "feed") {
                    FeedScreen(navController = navController)
                }
                composable(route = "detail/{plants}") { backStackEntry ->
                    val plantsString = backStackEntry.arguments?.getString("plants") ?: "CEL"
                    val plants = Plants.valueOf(plantsString)
                    DetailScreen(navController = navController, plants = plants)
                }
            }
        }
    }
}
