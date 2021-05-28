package com.indovision.belanja.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class CartResponse(
    @field:SerializedName("message")
    var message: String,
    @field:SerializedName("cart_id")
    var id: String,
    @field:SerializedName("cart_user_id")
    var userId: String,
    @field:SerializedName("cart_status")
    var status: String,
    @field:SerializedName("cart_items")
    var cartItems: List<CartItem>
)

data class CartItem(
    @field:SerializedName("item_id")
    var id: String,
    @field:SerializedName("item_name")
    var name: String,
    @field:SerializedName("item_price")
    var price: String,
    @field:SerializedName("item_quantity")
    var quantity: String
)
