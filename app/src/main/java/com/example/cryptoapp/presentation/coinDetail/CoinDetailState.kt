package com.example.cryptoapp.presentation.coinDetail

import com.example.cryptoapp.domain.models.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
