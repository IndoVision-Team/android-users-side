package com.indovision.belanja.data.source.remote.api

import com.indovision.belanja.data.source.remote.response.AdsResponse
import com.indovision.belanja.data.source.remote.response.EventResponse
import com.indovision.belanja.data.source.remote.response.ProductResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("events")
    fun getEvents() : Call<EventResponse>

    @GET("advertisment")
    fun getAds() : Call<AdsResponse>

    @GET("products/{id}")
    fun getProductRecommendations(@Path("id") id: String) : Call<ProductResponse>
}