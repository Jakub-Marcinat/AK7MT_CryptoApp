package com.example.cryptoapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp //for access to application context if needed for dependencies
class CoinApplication: Application() {

}