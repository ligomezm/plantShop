package com.ligomezm.plantshop.utilities

import com.ligomezm.plantshop.models.Product

class MockDataProvider {
    companion object {
        fun listOfProducts(): List<Product> {
            return listOf(
                Product(
                    0,
                    "Celosia",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                    80.0,
                    "USD",
                    "CEL"
                ),
                Product(
                    1,
                    "Miniature Cypress tree",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                    70.0,
                    "USD",
                    "CYP"
                ),
                Product(
                    2,
                    "Chamaedora Elegans",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                    60.0,
                    "USD",
                    "PAL"
                ),
                Product(
                    3,
                    "Jade",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                    50.0,
                    "USD",
                    "JAD"
                ),
            )
        }

        fun getProductBy(id: Int): Product? {
            val list = listOfProducts()
            return list.find { it.id == id }
        }
    }
}