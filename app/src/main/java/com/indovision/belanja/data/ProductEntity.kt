package com.indovision.belanja.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AdsEntity(
    val id: String = "",
    val imagePath: String = ""
) : Parcelable {
}