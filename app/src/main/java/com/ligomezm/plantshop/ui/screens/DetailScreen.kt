package com.ligomezm.plantshop.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
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
import com.ligomezm.plantshop.ui.components.BodyText
import com.ligomezm.plantshop.ui.components.CustomButton
import com.ligomezm.plantshop.ui.components.Plants
import com.ligomezm.plantshop.ui.components.TitleTextPreview
import com.ligomezm.plantshop.ui.theme.PlantShopTheme

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
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                ) {
                    Image(
                        painter = painterResource(id = plants.getPlantImage()),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Celosia Plant", style = MaterialTheme.typography.h5)
                    Text(
                        text = "Bring life to your home with this beautiful plant",
                        style = MaterialTheme.typography.caption)
                    Spacer(modifier = Modifier.height(24.dp))
                    BodyText(bodyText = "Bright colors plant that requieres full sun for minimun 4 hours a day, it is perfect for indoors or outdoors and easy care.")
                    Spacer(modifier = Modifier.height(24.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                       Text(
                           text = "$ 80.0 USD",
                           style = MaterialTheme.typography.h5,
                           textAlign = TextAlign.End
                       )
                        CustomButton(label = "Continuar") {
                            navController.navigate("ckeckout/${plants.iso}") {
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
    val navController = rememberNavController()
    PlantShopTheme() {
        DetailScreen(navController = navController, Plants.CELOSIA)
    }
}