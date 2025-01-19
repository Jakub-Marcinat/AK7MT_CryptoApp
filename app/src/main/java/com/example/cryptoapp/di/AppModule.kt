package com.example.cryptoapp.di

import com.example.cryptoapp.common.Constants
import com.example.cryptoapp.data.remoteData.dto.CoinApi
import com.example.cryptoapp.data.repositories.CoinRepositoryImplementation
import com.example.cryptoapp.domain.repositories.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class) //lifetime of the depencies in the module
object AppModule {

    @Provides
    @Singleton //single instance
    fun provideApi(): CoinApi {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build().create(CoinApi::class.java)
    }


    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinApi): CoinRepository {
        return CoinRepositoryImplementation(api)
    }
}