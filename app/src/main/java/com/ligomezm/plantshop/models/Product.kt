package com.ligomezm.plantshop.models

data class Product(
    val id: Int = 0,
    val name: String = "",
    val summary: String = "",
    val description: String = "",
    val price: Double = 0.0,
    val currency: String = "",
    val plantIso: String = "",
) {

}
