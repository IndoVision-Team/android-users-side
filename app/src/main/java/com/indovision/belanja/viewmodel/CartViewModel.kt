package com.indovision.belanja.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.indovision.belanja.data.CartEntity
import com.indovision.belanja.data.source.UserRepository

class CartViewModel(private val userRepository: UserRepository): ViewModel() {
    fun getCart(userId: String): LiveData<List<CartEntity>> = userRepository.getCart(userId)
}