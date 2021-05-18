package com.indovision.belanja.data.source.remote

import com.google.gson.annotations.SerializedName

data class EventResponse(
    @field:SerializedName("message")
    val message: String,
    @field:SerializedName("data")
    val events: List<Event>

)

data class Event (
    @field: SerializedName("event_id")
    val id: String,
    @field: SerializedName("event_banner_path")
    val imagePath: String
)
