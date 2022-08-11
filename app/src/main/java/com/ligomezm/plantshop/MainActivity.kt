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
import com.ligomezm.plantshop.ui.screens.CheckoutScreen
import com.ligomezm.plantshop.ui.screens.DetailScreen
import com.ligomezm.plantshop.ui.screens.FeedScreen
import com.ligomezm.plantshop.ui.theme.PlantShopTheme
import com.ligomezm.plantshop.utilities.MockDataProvider


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlantShopTheme {
                Surface(color = MaterialTheme.colors.background) {
                    NavigationHost()
                }
            }
        }
    }
}

@Composable
fun NavigationHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "feed") {
        composable(route = "feed") {
            FeedScreen(navController = navController)
        }
        composable(route = "detail/{productId}") { backStackEntry ->
            val productIdString = backStackEntry.arguments?.getString("productId") ?: "0"
            val productId = productIdString.toInt()
            val product = MockDataProvider.getProductBy(productId)
            DetailScreen(navController = navController, product!!)

        }
        composable(route = "checkout/{productId}") { backStackEntry ->
            val productIdString = backStackEntry.arguments?.getString("productId") ?: "0"
            val productId = productIdString.toInt()
            val product = MockDataProvider.getProductBy(productId)
            CheckoutScreen(navController = navController, product!!)
        }
    }
}
