package com.ligomezm.plantshop.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ligomezm.plantshop.ui.components.BodyText
import com.ligomezm.plantshop.ui.components.ProductCard
import com.ligomezm.plantshop.ui.components.TitleTex
import com.ligomezm.plantshop.utilities.MockDataProvider

@Composable
fun FeedScreen(
    navController: NavController,
) {
    val list = MockDataProvider.listOfProducts()
    Scaffold(
        topBar = {
            CustomAppBar(title = "Plant shop")
        },
        content = {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                item {
                    Column(
                        modifier = Modifier.padding(8.dp)
                    ) {
                        TitleTex(title = "Welcome")
                        BodyText(bodyText = "Here you will find all the plants available at the moment in our store, please browse around it and choose the perfect match for your house")
                    }
                }
                items(list) { product ->
                    ProductCard(navController, product)
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun FeedScreenPreview() {
    val navController = rememberNavController()
    FeedScreen(navController)
}