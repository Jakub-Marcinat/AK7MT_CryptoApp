package com.example.cryptoapp.domain.repositories

import com.example.cryptoapp.data.remoteData.dto.CoinDetailDto
import com.example.cryptoapp.data.remoteData.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinByID(coinID: String): CoinDetailDto
}