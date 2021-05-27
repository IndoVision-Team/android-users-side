package com.indovision.belanja.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ProfileResponse(
    @field:SerializedName("message")
    var message: String,
    @field:SerializedName("user_id")
    var id: String,
    @field:SerializedName("user_first_name")
    var firstName: String,
    @field:SerializedName("user_last_name")
    var lastName: String,
    @field:SerializedName("user_gender")
    var gender: String,
    @field:SerializedName("user_address")
    var address: String,
    @field:SerializedName("user_id")
    var email: String,
)
