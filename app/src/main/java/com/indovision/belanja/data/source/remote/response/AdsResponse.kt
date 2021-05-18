package com.indovision.belanja.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class AdsResponse(
    @field:SerializedName("message")
    val message: String,
    @field:SerializedName("data")
    val ads: List<Ads>

)

data class Ads (
    @field: SerializedName("ads_id")
    val id: String,
    @field: SerializedName("ads_banner_path")
    val imagePath: String
)
