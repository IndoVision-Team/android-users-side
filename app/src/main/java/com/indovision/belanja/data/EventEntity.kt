package com.indovision.belanja.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EventEntity(
    val id: String = "",
    val title: String = "",
    val description: String = "",
    val timeBegin: String = "",
    val timeStart: String = "",
    val imagePath: String = ""
): Parcelable {}