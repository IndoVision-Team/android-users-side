package com.indovision.belanja.ui.dashboard

import com.indovision.belanja.data.EventEntity
import com.indovision.belanja.data.ProductEntity
import com.indovision.belanja.data.AdsEntity
import retrofit2.Call
import retrofit2.http.GET

interface JsonPlaceHolderApi {
    @GET("events")
    fun getEvents(): Call<List<EventEntity>>

    @GET("advertisement")
    fun getAds(): Call<List<AdsEntity>>

    @GET("product_recommendation")
    fun getProductRecommendation(): Call<List<ProductEntity>>
}