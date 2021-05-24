package com.indovision.belanja.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class DetailProductResponse(
    @field: SerializedName("product_id")
    val id: String,
    @field: SerializedName("product_name")
    val name: String,
    @field: SerializedName("product_description")
    val description: String,
    @field: SerializedName("price_sell")
    val price: String,
    @field: SerializedName("image_path")
    val imagePath: Array<String>,
    @field: SerializedName("shop")
    val shop: Shop
)
