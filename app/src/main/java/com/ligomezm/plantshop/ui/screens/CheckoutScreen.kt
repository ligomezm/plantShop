package com.ligomezm.plantshop.ui.screens

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.ligomezm.plantshop.ui.components.CustomTextField
import com.ligomezm.plantshop.ui.theme.PlantShopTheme

@Composable
fun CheckoutScreen() {
    val availablePlants = listOf(
        "Jade", "Miniature cypress tree", "Celosia", "Chamaedora Elegans"
    )
    var plant by remember { mutableStateOf("") }
    
    DropDownTextField(
        suggestions = availablePlants,
        value = plant,
        placeholder = "Planta",
        onChangeValue = {
            plant = it
        })
}

@Preview(
    showBackground = true
)
@Composable
fun CheckoutScreenPreview() {
    PlantShopTheme {
        CheckoutScreen()
    }
}