package com.indovision.belanja.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class AccountResponse (
    @field:SerializedName("message")
    var message: String,
    @field:SerializedName("account_id")
    var id: String,
    @field:SerializedName("user_first_name")
    var firstName: String,
    @field:SerializedName("user_address")
    var address: String,
    @field:SerializedName("user_last_name")
    var lastName: String
)