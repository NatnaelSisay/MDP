package com.example.electronicsshop

import java.io.Serializable

class Product(
    val name: String,
    val description: String,
    val price: Double,
    val logo: Int,
    val image: Int
): Serializable {
}