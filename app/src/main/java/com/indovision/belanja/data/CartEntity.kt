package com.indovision.belanja.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CartEntity(
    var id: String,
    var cartid: String,
    var name: String,
    var price: String,
    var quantity: String
):Parcelable
