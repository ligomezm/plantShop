package com.ligomezm.plantshop.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.ligomezm.plantshop.ui.theme.PlantShopTheme

@Composable
fun BodyText(bodyText: String) {
    Text(bodyText,
        style = MaterialTheme.typography.body2,
        textAlign = TextAlign.Justify)
}

@Preview (
    showBackground = true
)
@Composable
fun BodyTextPreview() {
    PlantShopTheme {
        BodyText(bodyText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum")
    }
} 