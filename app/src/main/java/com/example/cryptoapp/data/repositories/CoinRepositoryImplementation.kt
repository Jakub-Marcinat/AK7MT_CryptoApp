package com.example.cryptoapp.data.repositories

import com.example.cryptoapp.data.remoteData.dto.CoinApi
import com.example.cryptoapp.data.remoteData.dto.CoinDetailDto
import com.example.cryptoapp.data.remoteData.dto.CoinDto
import com.example.cryptoapp.domain.repositories.CoinRepository
import javax.inject.Inject

class CoinRepositoryImplementation @Inject constructor(private val api: CoinApi):CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinByID(coinID: String): CoinDetailDto {

        return api.getCoinByID(coinID)
    }
}