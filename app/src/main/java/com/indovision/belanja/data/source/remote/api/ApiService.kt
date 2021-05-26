package com.indovision.belanja.data.source.remote.api

import com.indovision.belanja.data.source.remote.response.AdsResponse
import com.indovision.belanja.data.source.remote.response.DetailProductResponse
import com.indovision.belanja.data.source.remote.response.EventResponse
import com.indovision.belanja.data.source.remote.response.ProductResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("events")
    fun getEvents() : Call<EventResponse>

    @GET("advertisment")
    fun getAds() : Call<AdsResponse>

    @GET("products/{id}")
    fun getProductRecommendations(@Path("userId") id: String) : Call<ProductResponse>

    @GET("products")
    fun getProductSearch(@Query("search") search: String) : Call<ProductResponse>

    @GET("products/{id}")
    fun getProductDetail(@Path("productId") id: String) : Call<DetailProductResponse>
}