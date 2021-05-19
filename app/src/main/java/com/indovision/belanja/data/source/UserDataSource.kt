package com.indovision.belanja.data.source

import androidx.lifecycle.LiveData
import com.indovision.belanja.data.AdsEntity
import com.indovision.belanja.data.EventEntity
import com.indovision.belanja.data.ProductEntity

interface UserDataSource {
    fun getAllEvent(): LiveData<List<EventEntity>>

    fun getAllAds(): LiveData<List<AdsEntity>>

    fun getAllProductRecommendation(userId: String) : LiveData<List<ProductEntity>>
    
    fun getAllProductSearch(search: String) : LiveData<List<ProductEntity>>
}