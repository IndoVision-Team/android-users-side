package com.indovision.belanja.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EventEntity(
    var id: String = "",
    var title: String = "",
    var description: String = "",
    var timeBegin: String = "",
    var timeStart: String = "",
    var imagePath: String = ""
): Parcelable {}