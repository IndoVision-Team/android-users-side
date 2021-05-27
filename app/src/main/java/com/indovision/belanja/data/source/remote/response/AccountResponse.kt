package com.indovision.belanja.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class AccountResponse (
    @field:SerializedName("message")
    var message: String,
    @field:SerializedName("account_id")
    var id: String,
    @field:SerializedName("user_first_name")
    var first_name: String,
    @field:SerializedName("user_last_name")
    var last_name: String
)