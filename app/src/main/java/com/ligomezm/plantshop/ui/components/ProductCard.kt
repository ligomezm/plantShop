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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ligomezm.plantshop.R
import com.ligomezm.plantshop.ui.theme.Blue
import com.ligomezm.plantshop.ui.theme.PlantShopTheme

enum class Plants(val iso: String) {
    CELOSIA("CEL"),
    CYPRESS("CYP"),
    PALM("PAL"),
    JADE("JAD");

    fun getPlantImage() : Int {
        return when(this) {
            CELOSIA -> R.drawable.plant1
            CYPRESS -> R.drawable.plant2
            PALM -> R.drawable.plant3
            JADE -> R.drawable.plant4
        }
    }

    fun getSunImage(): Int {
        return when(this) {
            CELOSIA, JADE -> R.drawable.sun
            PALM -> R.drawable.part_sun
            CYPRESS -> R.drawable.shade
        }
    }
}

typealias SelectionAction = () -> Unit

@Composable
fun ProductCard(name: String,
                details: String,
                price: Double,
                currency: String,
                plants: Plants,
                selected: SelectionAction
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                selected()
            }
            .size(400.dp),
        elevation = 10.dp,
        shape = MaterialTheme.shapes.small
    ) {
        Image(
            painter = painterResource(plants.getPlantImage()),
            contentDescription = null)
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = Blue.copy(alpha = 0.2f)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)) {
                Text(
                    name,
                    style = MaterialTheme.typography.h4)
                Text(
                    details,
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
                            painter = painterResource(plants.getSunImage()),
                            contentDescription = null,
                            modifier = Modifier.size(48.dp)
                        )
                        Text(
                            text = "$ $price $currency",
                            style = MaterialTheme.typography.h4)
                    }
                }
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun ProductCardPreview() {
    PlantShopTheme {
        ProductCard(
            "Cypress tree",
            "Beatiful ornamental plant, perfect for indoors.",
            80.0,
            "USD",
            Plants.CYPRESS
        ) {}
    }
}