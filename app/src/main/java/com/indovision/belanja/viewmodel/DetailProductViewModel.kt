package com.indovision.belanja.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.indovision.belanja.data.ProductEntity
import com.indovision.belanja.data.source.UserRepository

class DetailProductViewModel(private val userRepository: UserRepository) : ViewModel() {
    fun getProductDetail(productId: String): LiveData<ProductEntity> =
        userRepository.getProductDetail(productId)
}