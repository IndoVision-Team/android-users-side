package com.indovision.belanja.data.source.remote.response

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
    @field: SerializedName("event_title")
    val title: String,
    @field: SerializedName("event_description")
    val description: String,
    @field: SerializedName("event_time_begin")
    val timeBegin: String,
    @field: SerializedName("event_time_start")
    val timeStart: String,
    @field: SerializedName("event_banner_path")
    val imagePath: String
)
