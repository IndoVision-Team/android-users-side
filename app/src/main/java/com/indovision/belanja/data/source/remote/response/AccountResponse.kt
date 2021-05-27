package com.indovision.belanja.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class AccountResponse (
    @field:SerializedName("message")
    var message: String,
    @field:SerializedName("name")
    var name: String
)