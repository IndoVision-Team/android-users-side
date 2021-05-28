package com.indovision.belanja.data.source

import androidx.lifecycle.LiveData
import com.indovision.belanja.data.*

interface UserDataSource {
    fun getAllEvent(): LiveData<List<EventEntity>>

    fun getAllAds(): LiveData<List<AdsEntity>>

    fun getAllProductRecommendation(userId: String) : LiveData<List<ProductEntity>>
    
    fun getAllProductSearch(search: String) : LiveData<List<ProductEntity>>

    fun getProductDetail(productId: String) : LiveData<ProductEntity>

    fun getAccount(userId: String): LiveData<AccountEntity>

    fun getProfile(userId: String): LiveData<UserEntity>

    fun getCart(userId: String): LiveData<List<CartEntity>>
}