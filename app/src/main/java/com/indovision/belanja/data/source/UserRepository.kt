package com.indovision.belanja.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.indovision.belanja.data.AdsEntity
import com.indovision.belanja.data.EventEntity
import com.indovision.belanja.data.ProductEntity
import com.indovision.belanja.data.ShopEntity
import com.indovision.belanja.data.source.remote.RemoteDataSource
import com.indovision.belanja.data.source.remote.RemoteDataSource.LoadEventsCallback
import com.indovision.belanja.data.source.remote.RemoteDataSource.LoadAdsCallback
import com.indovision.belanja.data.source.remote.RemoteDataSource.LoadProductRecommendationsCallback
import com.indovision.belanja.data.source.remote.response.Ads
import com.indovision.belanja.data.source.remote.response.Event
import com.indovision.belanja.data.source.remote.response.Product

class UserRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    UserDataSource {
    companion object {
        @Volatile
        private var instance: UserRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): UserRepository =
            instance ?: synchronized(this){
                instance ?: UserRepository(remoteDataSource).apply { instance = this }
            }
    }

    override fun getAllEvent(): LiveData<List<EventEntity>> {
        val eventResult = MutableLiveData<List<EventEntity>>()
        remoteDataSource.getEvents(object : LoadEventsCallback{
            override fun onAllEventReceived(events: List<Event>) {
                val eventList = ArrayList<EventEntity>()
                for(event in events){
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
        remoteDataSource.getAds(object : LoadAdsCallback{
            override fun onAllAdsReceived(ads: List<Ads>) {
                val adsList = ArrayList<AdsEntity>()
                for(ad in ads){
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
        remoteDataSource.getProductRecommendations(userId, object : LoadProductRecommendationsCallback{
            override fun onAllProductRecommendationReceived(productRecommendations: List<Product>) {
                val productList = ArrayList<ProductEntity>()
                for(product in productRecommendations){
                    val shop = ShopEntity(product.shop.id, product.shop.name,product.shop.address)
                    productList.add(
                        ProductEntity(
                            product.id,
                            product.name,
                            product.description,
                            product.price,
                            product.imagePath,
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
        remoteDataSource.getProductSearch(search, object : RemoteDataSource.LoadProductSearchCallback{
            override fun onAllProductSearchReceived(productSearch: List<Product>) {
                val productList = ArrayList<ProductEntity>()
                for(product in productSearch){
                    val shop = ShopEntity(product.shop.id, product.shop.name,product.shop.address)
                    productList.add(
                        ProductEntity(
                            product.id,
                            product.name,
                            product.description,
                            product.price,
                            product.imagePath,
                            shop
                        )
                    )
                }
                productResult.postValue(productList)
            }
        })
        return productResult
    }
}