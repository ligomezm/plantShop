package com.ligomezm.plantshop.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ligomezm.plantshop.models.Product
import com.ligomezm.plantshop.ui.components.BodyText
import com.ligomezm.plantshop.ui.components.CustomButton
import com.ligomezm.plantshop.ui.components.Plants
import com.ligomezm.plantshop.ui.theme.PlantShopTheme
import com.ligomezm.plantshop.utilities.MockDataProvider

@Composable
fun DetailScreen(
    navController: NavController,
    product: Product,
) {
    val plant = Plants.valueOf(product.plantIso)

    Scaffold(
        topBar = {
            CustomAppBar(navigationIcon = Icons.Filled.ArrowBack) {
                navController.navigate("feed") {
                    popUpTo("feed")
                }
            }
        },
        content = {
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                ) {
                    Image(
                        painter = painterResource(id = plant.getPlantImage()),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = product.name, style = MaterialTheme.typography.h5)
                    Text(
                        text = product.summary,
                        style = MaterialTheme.typography.caption)
                    Spacer(modifier = Modifier.height(24.dp))
                    BodyText(bodyText = product.description)
                    Spacer(modifier = Modifier.height(24.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text(
                            text = "$ ${product.price} ${product.currency}",
                            style = MaterialTheme.typography.h5,
                            textAlign = TextAlign.End
                        )
                        CustomButton(label = "Continuar") {
                            navController.navigate("checkout/${product.id}") {
                                launchSingleTop = true
                            }
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
fun DetailScreenPreview() {
    val product = MockDataProvider.getProductBy(0)
    if (product != null) {
        val navController = rememberNavController()
        PlantShopTheme {
            DetailScreen(navController = navController, product)
        }
    } else {
        Text(text = "Error loading preview")
    }
}