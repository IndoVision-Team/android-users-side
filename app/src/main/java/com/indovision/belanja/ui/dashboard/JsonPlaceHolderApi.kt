package com.indovision.belanja.ui.dashboard

import com.indovision.belanja.data.EventEntity
import retrofit2.Call
import retrofit2.http.GET

interface JsonPlaceHolderApi {
    @GET("events")
    fun getEvents(): Call<List<EventEntity>>
}