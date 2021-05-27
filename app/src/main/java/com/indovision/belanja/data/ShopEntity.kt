package com.indovision.belanja.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ShopEntity(
    var id: String = "",
    var name: String = "",
    var address: String = "",
    var imagePath: String = ""
):Parcelable {
}