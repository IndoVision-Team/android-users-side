package com.indovision.belanja.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserEntity(
    var id: String,
    var firstName: String,
    var lastName: String,
    var gender: String,
    var address: String,
    var email: String,
    var imagePath: String
):Parcelable
