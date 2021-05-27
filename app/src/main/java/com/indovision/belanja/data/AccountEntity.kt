package com.indovision.belanja.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AccountEntity(
    var id: String = "",
    var address: String = "",
    var firstName: String = "",
    var lastName: String = ""
):Parcelable
