package com.indovision.belanja.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.indovision.belanja.data.ProductEntity
import com.indovision.belanja.data.source.UserRepository

class SearchViewModel(private val userRepository: UserRepository) : ViewModel() {
    fun getProductSearch(search: String): LiveData<List<ProductEntity>> =
        userRepository.getAllProductSearch(search)
}