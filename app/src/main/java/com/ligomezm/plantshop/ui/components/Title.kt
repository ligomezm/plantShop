package com.ligomezm.plantshop.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ligomezm.plantshop.ui.theme.PlantShopTheme

@Composable
fun TitleTex(title: String) {
    Text(title, style = MaterialTheme.typography.h3)
}

@Preview(
    showBackground = true
)

@Composable
fun TitleTextPreview() {
    PlantShopTheme() {
        TitleTex("Title")
    }

}