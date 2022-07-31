package com.ligomezm.plantshop.ui.screens

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.ligomezm.plantshop.ui.theme.PlantShopTheme

typealias NavigationAction = () -> Unit

@Composable
fun CustomAppBar(
    title: String? = null,
    navigationIcon: ImageVector? = null,
    navigationAction: NavigationAction? = null
    ) {
    val titleText = title ?: ""
    if (navigationIcon != null && navigationAction != null) {
        TopAppBar(
            title = { Text(text = titleText)},
            navigationIcon = {
                             IconButton(onClick = {
                                 navigationAction()
                             }) {
                                 Icon(navigationIcon, "")

                             }
            },
            backgroundColor = MaterialTheme.colors.secondary)
    } else {
        TopAppBar(
            title = { Text(text = titleText)},
            backgroundColor = MaterialTheme.colors.secondary)
    }
}

@Preview(
    showBackground = true
)
@Composable
fun CustomAppBarPreview() {
    PlantShopTheme {
       CustomAppBar("Plant Shop")
    }

}