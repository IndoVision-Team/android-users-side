package com.indovision.belanja.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.indovision.belanja.data.AccountEntity
import com.indovision.belanja.data.source.UserRepository

class AccountViewModel(private val userRepository: UserRepository): ViewModel() {
    fun getAccount(userId : String): LiveData<AccountEntity> = userRepository.getAccount(userId)
}