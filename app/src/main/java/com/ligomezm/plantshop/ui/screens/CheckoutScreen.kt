package com.ligomezm.plantshop.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ligomezm.plantshop.models.Product
import com.ligomezm.plantshop.ui.components.Alert
import com.ligomezm.plantshop.ui.components.CustomButton
import com.ligomezm.plantshop.ui.components.CustomTextField
import com.ligomezm.plantshop.ui.components.ProductCard
import com.ligomezm.plantshop.ui.theme.PlantShopTheme
import com.ligomezm.plantshop.utilities.MockDataProvider

@Composable
fun CheckoutScreen(
    navController: NavController,
    product: Product,
) {
    val availablePlants = listOf(
        "Jade", "Miniature cypress tree", "Celosia", "Chamaedora Elegans"
    )
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var plant by remember { mutableStateOf("") }
    var message by remember { mutableStateOf<String?>(null) }

    Scaffold(topBar = {
        CustomAppBar(navigationIcon = Icons.Filled.ArrowBack) {
            navController.navigate("detail/${product.id}")
        }
    }, content = {
        Alert(title = "Congratulations", message = message) {
            navController.navigate("feed") {
                launchSingleTop = true
                popUpTo("feed")
            }
        }
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            ProductCard(navController, product)

            Column(modifier = Modifier.padding(16.dp)) {
                CustomTextField(
                    value = name,
                    placeholder = "Name",
                ) {
                    name = it
                }
                CustomTextField(
                    value = email, placeholder = "Email",
                ) {
                    email = it
                }
                CustomTextField(
                    value = phone, placeholder = "Phone number",
                ) {
                    phone = it
                }
                CustomTextField(
                    value = address, placeholder = "Address",
                ) {
                    address = it
                }
                DropDownTextField(
                    suggestions = availablePlants,
                    value = plant,
                    placeholder = "Planta") {
                    plant = it
                }
                Column {
                    Row {
                        Text(text = "Subtotal", style = MaterialTheme.typography.caption)
                        Text(
                            text = "$ 80.0 USD",
                            style = MaterialTheme.typography.body2,
                            textAlign = TextAlign.End,
                            modifier = Modifier.fillMaxWidth())
                    }
                    Row {
                        Text(text = "Envío", style = MaterialTheme.typography.caption)
                        Text(text = "$ 10.0 USD", style = MaterialTheme.typography.body2,
                            modifier = Modifier.fillMaxWidth())
                    }
                }
                Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    Text(
                        text = "$ 45.0 USD",
                        style = MaterialTheme.typography.h5,
                        textAlign = TextAlign.Start
                    )
                    CustomButton(label = "Finish order") {
                        message = "Your order was successfully created"
                    }
                }
            }
        }
    }
    )
}

@Preview(
    showBackground = true
)
@Composable
fun CheckoutScreenPreview() {
    val product = MockDataProvider.getProductBy(0)
    if (product != null) {
        val navController = rememberNavController()
        PlantShopTheme {
            CheckoutScreen(navController, product)
        }
    }
}