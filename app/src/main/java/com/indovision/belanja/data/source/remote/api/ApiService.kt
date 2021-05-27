package com.indovision.belanja.data.source.remote.api

import com.indovision.belanja.data.source.remote.response.*
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

    @GET("account/{id}")
    fun getAccount(@Path("accountId") id: String) : Call<AccountResponse>

    @GET("profile/{id}")
    fun getProfile(@Path("userId") id: String) : Call<ProfileResponse>
}