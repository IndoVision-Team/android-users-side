package com.indovision.belanja.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ShopEntity(
    val id: String = "",
    val name: String = "",
    val address: String = "",
    val imagePath: String = ""
):Parcelable {
}