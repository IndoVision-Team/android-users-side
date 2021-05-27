package com.indovision.belanja.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AccountEntity(
    val id: String = "",
    val firstName: String = "",
    val lastName: String = ""
):Parcelable
