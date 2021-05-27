package com.indovision.belanja.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.indovision.belanja.data.UserEntity
import com.indovision.belanja.data.source.UserRepository

class ProfileViewModel(private val userRepository: UserRepository): ViewModel() {
    fun getProfile(userId: String): LiveData<UserEntity> = userRepository.getProfile(userId)
}