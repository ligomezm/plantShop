package com.ligomezm.plantshop.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ligomezm.plantshop.ui.components.BodyText
import com.ligomezm.plantshop.ui.components.ProductCard
import com.ligomezm.plantshop.ui.components.Plants
import com.ligomezm.plantshop.ui.components.TitleTex
import com.ligomezm.plantshop.ui.theme.PlantShopTheme

@Composable
fun FeedScreen(navController: NavController) {

    val list = listOf<Plants>(
        Plants.CYPRESS, Plants.PALM, Plants.JADE, Plants.CELOSIA
    )

    PlantShopTheme {
        Surface(
            color = MaterialTheme.colors.background
        ) {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    Column(
                        modifier = Modifier.padding(8.dp)
                    ) {
                        TitleTex(title = "Welcome")
                        BodyText(bodyText = "Here you will find all the plants available at the moment in our store, please browse around it and choose the perfect match for your house")
                    }
                }
                items(list) { plants ->
                    ProductCard(
                        name = "Prueba",
                        details = "Prueba",
                        price = 80.0,
                        currency = "Prueba",
                        plants = plants
                    ) {
                        navController.navigate("detail/${plants.iso}") {
                            launchSingleTop = true
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FeedScreenPreview() {
    val navController = rememberNavController()
    FeedScreen(navController)
}