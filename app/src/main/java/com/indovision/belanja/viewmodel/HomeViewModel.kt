package com.indovision.belanja.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.indovision.belanja.data.AdsEntity
import com.indovision.belanja.data.EventEntity
import com.indovision.belanja.data.ProductEntity
import com.indovision.belanja.data.source.UserRepository

class HomeViewModel(private val userRepository: UserRepository) : ViewModel() {
    fun getEvents(): LiveData<List<EventEntity>> = userRepository.getAllEvent()

    fun getAds(): LiveData<List<AdsEntity>> = userRepository.getAllAds()

    fun getRecommendations(userId: String): LiveData<List<ProductEntity>> =
        userRepository.getAllProductRecommendation(userId)
}