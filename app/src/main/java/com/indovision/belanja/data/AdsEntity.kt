package com.indovision.belanja.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AdsEntity(
    var id: String = "",
    var imagePath: String = ""
) : Parcelable {
}