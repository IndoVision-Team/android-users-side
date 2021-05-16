package com.indovision.belanja.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class ProductEntity(
    var id: String = "",
    var name: String = "",
    var description: String = "",
    var price: String = "",
    var imagePath: Array<String> = arrayOf("")
) : Parcelable {}