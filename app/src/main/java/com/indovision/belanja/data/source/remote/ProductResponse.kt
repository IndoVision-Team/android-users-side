package com.indovision.belanja.data.source.remote

import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @field:SerializedName("message")
    val message: String,
    @field:SerializedName("data")
    val events: List<Product>
)

data class Product (
    @field: SerializedName("product_id")
    val id: String,
    @field: SerializedName("product_name")
    val name: String,
    @field: SerializedName("product_description")
    val description: String,
    @field: SerializedName("price_sell")
    val price: String,
    @field: SerializedName("image_path")
    val imagePath: String,
    @field: SerializedName("shop")
    val shop: Shop,
)

data class Shop (
    @field: SerializedName("shop_id")
    val id: String,
    @field: SerializedName("shop_name")
    val name: String,
    @field: SerializedName("shop_address")
    val address: String
)
