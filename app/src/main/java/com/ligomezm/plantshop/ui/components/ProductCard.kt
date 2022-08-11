package com.ligomezm.plantshop.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ligomezm.plantshop.R
import com.ligomezm.plantshop.models.Product
import com.ligomezm.plantshop.ui.theme.Blue

enum class Plants {
    CEL, CYP, PAL, JAD;

    fun getPlantImage(): Int {
        return when (this) {
            CEL -> R.drawable.plant1
            CYP -> R.drawable.plant2
            PAL -> R.drawable.plant3
            JAD -> R.drawable.plant4
        }
    }

    fun getSunImage(): Int {
        return when (this) {
            CEL, JAD -> R.drawable.sun
            PAL -> R.drawable.part_sun
            CYP -> R.drawable.shade
        }
    }
}


@Composable
fun ProductCard(
    navController: NavController,
    product: Product,
) {
    val plant = Plants.valueOf(product.plantIso)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                navController.navigate("detail/${product.id}") {
                    launchSingleTop = true
                }
            }
            .size(400.dp),
        elevation = 10.dp,
        shape = MaterialTheme.shapes.small
    ) {
        Image(
            painter = painterResource(plant.getPlantImage()),
            contentDescription = null)
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = Blue.copy(alpha = 0.2f)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)) {
                Text(
                    product.name,
                    style = MaterialTheme.typography.h4)
                Text(
                    product.summary,
                    style = MaterialTheme.typography.body1)
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Image(
                            painter = painterResource(plant.getSunImage()),
                            contentDescription = null,
                            modifier = Modifier.size(48.dp)
                        )
                        Text(
                            text = "$ ${product.price} ${product.currency}",
                            style = MaterialTheme.typography.h4)
                    }
                }
            }
        }
    }
}
