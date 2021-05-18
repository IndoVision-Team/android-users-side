package com.indovision.belanja.data.source

import com.indovision.belanja.data.AdsEntity
import com.indovision.belanja.data.EventEntity

interface UserDataSource {
    fun getAllEvent(): List<EventEntity>

    fun getAllAds(): List<AdsEntity>

    fun getAllProductRecommendation(userId: String)
}