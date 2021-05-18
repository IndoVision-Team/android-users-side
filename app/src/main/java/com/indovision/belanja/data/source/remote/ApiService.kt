package com.indovision.belanja.data.source.remote

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("events")
    fun getEvents() : Call<EventResponse>

    @GET("products")
    fun getProductRecommendations() : Call<ProductResponse>
}