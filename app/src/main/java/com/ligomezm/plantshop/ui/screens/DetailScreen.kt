package com.ligomezm.plantshop.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ligomezm.plantshop.ui.components.Plants

@Composable
fun DetailScreen(navController: NavController, plants: Plants) {
    Scaffold(
        topBar = {
            CustomAppBar(navigationIcon = Icons.Filled.ArrowBack ) {
                navController.navigate("feed") {
                    popUpTo("feed")
                }
            }
        },
        content = {
            Column() {
                Text(text = "Name of the plant: ${plants.iso}", style = MaterialTheme.typography.h3)
                Button(onClick = {
                    navController.navigate("feed") {
                        popUpTo("feed")
                    }
                }) {
                    Text(text = "Back")
                }
            }
        }
    )
    

}

@Preview(
    showBackground = true
)
@Composable
fun DetailScreenPreview() {
    val navController = rememberNavController()
    DetailScreen(navController = navController, Plants.CELOSIA)
}