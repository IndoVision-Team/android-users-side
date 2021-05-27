package com.indovision.belanja.data.source.remote

import android.util.Log
import com.indovision.belanja.data.source.remote.api.ApiConfig
import com.indovision.belanja.data.source.remote.response.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {
    companion object{
        @Volatile
        private var instance : RemoteDataSource? = null

        fun getInstance(): RemoteDataSource = instance ?: synchronized(this){
            instance ?: RemoteDataSource().apply { instance = this }
        }
    }

    fun getEvents(callback: LoadEventsCallback){
        val client = ApiConfig.getApiService().getEvents()
        client.enqueue(object : Callback<EventResponse>{
            override fun onResponse(call: Call<EventResponse>, response: Response<EventResponse>) {
                if(response.isSuccessful) {
                    val eventResponse = response.body() as EventResponse
                    if(eventResponse.message == "success")
                         callback.onAllEventReceived(eventResponse.events)
                }
            }

            override fun onFailure(call: Call<EventResponse>, t: Throwable) {
                debugError(t)
            }

        })
    }

    fun getProductRecommendations(userId: String, callback: LoadProductRecommendationsCallback){
        val client = ApiConfig.getApiService().getProductRecommendations(userId)
        client.enqueue(object : Callback<ProductResponse>{
            override fun onResponse(
                call: Call<ProductResponse>,
                response: Response<ProductResponse>
            ) {
                if(response.isSuccessful){
                    val productResponse = response.body() as ProductResponse
                    if(productResponse.message == "success")
                        callback.onAllProductRecommendationReceived(productResponse.products)
                }
            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                debugError(t)
            }

        })
    }

    fun getAds(callback: LoadAdsCallback){
        val client = ApiConfig.getApiService().getAds()
        client.enqueue(object : Callback<AdsResponse>{
            override fun onResponse(call: Call<AdsResponse>, response: Response<AdsResponse>) {
                if(response.isSuccessful){
                    val adsResponse = response.body() as AdsResponse
                    if(adsResponse.message == "success")
                        callback.onAllAdsReceived(adsResponse.ads)
                }
            }

            override fun onFailure(call: Call<AdsResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun getProductSearch(search: String, callback: LoadProductSearchCallback){
        val client = ApiConfig.getApiService().getProductSearch(search)
        client.enqueue(object : Callback<ProductResponse>{
            override fun onResponse(
                call: Call<ProductResponse>,
                response: Response<ProductResponse>
            ) {
                if(response.isSuccessful){
                    val productResponse = response.body() as ProductResponse
                    if(productResponse.message == "success")
                        callback.onAllProductSearchReceived(productResponse.products)
                }
            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                debugError(t)
            }

        })
    }

    fun getProductDetail(productId: String, callback: LoadProductDetailCallback){
        val client = ApiConfig.getApiService().getProductDetail(productId)
        client.enqueue(object : Callback<DetailProductResponse>{
            override fun onResponse(
                call: Call<DetailProductResponse>,
                response: Response<DetailProductResponse>
            ) {
                if(response.isSuccessful){
                    val detailProductResponse = response.body() as DetailProductResponse
                    if(detailProductResponse.message == "success")
                        callback.onProductDetailReceived(detailProductResponse.data)
                }
            }

            override fun onFailure(call: Call<DetailProductResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }


        })
    }

    fun getAccount(userId: String, callback: LoadAccountCallback){
        val client = ApiConfig.getApiService().getAccount(userId)
        client.enqueue(object : Callback<AccountResponse>{
            override fun onResponse(
                call: Call<AccountResponse>,
                response: Response<AccountResponse>
            ) {
                if(response.isSuccessful){
                    val accountResponse = response.body() as AccountResponse
                    if(accountResponse.message == "success")
                        callback.onAccountReceived(accountResponse)
                }
            }

            override fun onFailure(call: Call<AccountResponse>, t: Throwable) {
                debugError(t)
            }

        })
    }

    fun getProfile(userId: String, callback: LoadProfileCallback){
        val client = ApiConfig.getApiService().getProfile(userId)
        client.enqueue(object : Callback<ProfileResponse>{
            override fun onResponse(
                call: Call<ProfileResponse>,
                response: Response<ProfileResponse>
            ) {
                if(response.isSuccessful){
                    val profileResponse = response.body() as ProfileResponse
                    if(profileResponse.message == "success")
                        callback.onProfileReceived(profileResponse)
                }
            }

            override fun onFailure(call: Call<ProfileResponse>, t: Throwable) {
                debugError(t)
            }


        })
    }

    private fun debugError(t: Throwable) {
        Log.d(RemoteDataSource::class.java.simpleName, "onFailure: ${t.message}")
    }

    interface LoadProfileCallback {
        fun onProfileReceived(profileResponse: ProfileResponse)
    }

    interface LoadAccountCallback {
        fun onAccountReceived(accountResponse: AccountResponse)
    }

    interface LoadAdsCallback {
        fun onAllAdsReceived(ads: List<Ads>)
    }

    interface LoadProductRecommendationsCallback {
        fun onAllProductRecommendationReceived(productRecommendations: List<Product>)
    }

    interface LoadEventsCallback {
        fun onAllEventReceived(events: List<Event>)
    }

    interface LoadProductSearchCallback {
        fun onAllProductSearchReceived(productSearch: List<Product>)
    }

    interface LoadProductDetailCallback {
        fun onProductDetailReceived(productDetail: DetailProduct)
    }
}