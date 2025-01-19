package com.example.cryptoapp.domain.useCases.getCoins

import com.example.cryptoapp.common.Resource
import com.example.cryptoapp.data.remoteData.dto.toCoin
import com.example.cryptoapp.domain.models.Coin
import com.example.cryptoapp.domain.repositories.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins)) //forwarding data to view model
        }catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Niekde nastala chyba :} "))
        }catch (e: IOException) {
            emit(Resource.Error("Skontroluj internety"))
        }
    }

}