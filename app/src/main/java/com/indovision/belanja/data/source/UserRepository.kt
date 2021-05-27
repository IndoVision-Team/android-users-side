package com.indovision.belanja.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.indovision.belanja.data.*
import com.indovision.belanja.data.source.remote.RemoteDataSource
import com.indovision.belanja.data.source.remote.RemoteDataSource.LoadEventsCallback
import com.indovision.belanja.data.source.remote.RemoteDataSource.LoadAdsCallback
import com.indovision.belanja.data.source.remote.RemoteDataSource.LoadProductRecommendationsCallback
import com.indovision.belanja.data.source.remote.RemoteDataSource.LoadProductSearchCallback
import com.indovision.belanja.data.source.remote.RemoteDataSource.LoadProductDetailCallback
import com.indovision.belanja.data.source.remote.RemoteDataSource.LoadAccountCallback
import com.indovision.belanja.data.source.remote.response.*

class UserRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    UserDataSource {
    companion object {
        @Volatile
        private var instance: UserRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): UserRepository =
            instance ?: synchronized(this) {
                instance ?: UserRepository(remoteDataSource).apply { instance = this }
            }
    }

    override fun getAllEvent(): LiveData<List<EventEntity>> {
        val eventResult = MutableLiveData<List<EventEntity>>()
        remoteDataSource.getEvents(object : LoadEventsCallback {
            override fun onAllEventReceived(events: List<Event>) {
                val eventList = ArrayList<EventEntity>()
                for (event in events) {
                    eventList.add(
                        EventEntity(
                            event.id,
                            event.title,
                            event.description,
                            event.timeBegin,
                            event.timeStart,
                            event.imagePath
                        )
                    )
                }
                eventResult.postValue(eventList)
            }

        })
        return eventResult
    }

    override fun getAllAds(): LiveData<List<AdsEntity>> {
        val adsResult = MutableLiveData<List<AdsEntity>>()
        remoteDataSource.getAds(object : LoadAdsCallback {
            override fun onAllAdsReceived(ads: List<Ads>) {
                val adsList = ArrayList<AdsEntity>()
                for (ad in ads) {
                    adsList.add(
                        AdsEntity(
                            ad.id,
                            ad.imagePath
                        )
                    )
                }
                adsResult.postValue(adsList)
            }
        })
        return adsResult
    }

    override fun getAllProductRecommendation(userId: String): LiveData<List<ProductEntity>> {
        val productResult = MutableLiveData<List<ProductEntity>>()
        remoteDataSource.getProductRecommendations(
            userId,
            object : LoadProductRecommendationsCallback {
                override fun onAllProductRecommendationReceived(productRecommendations: List<Product>) {
                    val productList = ArrayList<ProductEntity>()
                    for (product in productRecommendations) {
                        val shop =
                            ShopEntity(product.shop.id, product.shop.name, product.shop.address)
                        productList.add(
                            ProductEntity(
                                product.id,
                                product.name,
                                product.description,
                                product.price,
                                arrayOf(product.imagePath),
                                shop
                            )
                        )
                    }
                    productResult.postValue(productList)
                }
            })
        return productResult
    }

    override fun getAllProductSearch(search: String): LiveData<List<ProductEntity>> {
        val productResult = MutableLiveData<List<ProductEntity>>()
        remoteDataSource.getProductSearch(search, object : LoadProductSearchCallback {
            override fun onAllProductSearchReceived(productSearch: List<Product>) {
                val productList = ArrayList<ProductEntity>()
                for (product in productSearch) {
                    val shop = ShopEntity(product.shop.id, product.shop.name, product.shop.address)
                    productList.add(
                        ProductEntity(
                            product.id,
                            product.name,
                            product.description,
                            product.price,
                            arrayOf(product.imagePath),
                            shop
                        )
                    )
                }
                productResult.postValue(productList)
            }
        })
        return productResult
    }

    override fun getProductDetail(productId: String): LiveData<ProductEntity> {
        val productResult = MutableLiveData<ProductEntity>()
        remoteDataSource.getProductDetail(productId, object : LoadProductDetailCallback {
            override fun onProductDetailReceived(productDetail: DetailProduct) {
                val shop = ShopEntity(
                    productDetail.shop.id,
                    productDetail.shop.name,
                    productDetail.shop.address
                )
                productResult.postValue(
                    ProductEntity(
                        productDetail.id,
                        productDetail.name,
                        productDetail.description,
                        productDetail.price,
                        productDetail.imagePath,
                        shop
                    )
                )


            }
        })
        return productResult
    }

    override fun getAccount(userId: String): LiveData<AccountEntity> {
        val accountResult = MutableLiveData<AccountEntity>()
        remoteDataSource.getAccount(userId, object : LoadAccountCallback {
            override fun onAccountReceived(accountResponse: AccountResponse) {
                accountResult.postValue(
                    AccountEntity(
                        accountResponse.id,
                        accountResponse.firstName,
                        accountResponse.lastName
                    )
                )
            }
        })
        return accountResult
    }

    override fun getProfile(userId: String): LiveData<UserEntity> {
        val profileResult = MutableLiveData<UserEntity>()
        remoteDataSource.getProfile(userId, object : RemoteDataSource.LoadProfileCallback {
            override fun onProfileReceived(profileResponse: ProfileResponse) {
                profileResult.postValue(
                    UserEntity(
                        profileResponse.id,
                        profileResponse.firstName,
                        profileResponse.lastName,
                        profileResponse.gender,
                        profileResponse.address,
                        profileResponse.email
                    )
                )
            }
        })
        return profileResult
    }
}