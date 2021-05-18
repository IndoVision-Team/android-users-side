package com.indovision.belanja.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.indovision.belanja.data.source.UserRepository
import com.indovision.belanja.viewmodel.DashboardViewModel
import com.indovision.belanja.data.source.remote.RemoteDataSource

class ViewModelFactory private constructor(private val userRepository: UserRepository) :
    ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(remoteDataSource: RemoteDataSource): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(UserRepository.getInstance(remoteDataSource))
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when{
            modelClass.isAssignableFrom(DashboardViewModel::class.java)->{
                return DashboardViewModel(userRepository) as T
            }
        }
    }
}