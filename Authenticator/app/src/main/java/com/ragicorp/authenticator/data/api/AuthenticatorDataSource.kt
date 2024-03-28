package com.ragicorp.authenticator.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AuthenticatorDataSource {
    private val apiService = Retrofit.Builder()
        .baseUrl("https://www.randomnumberapi.com")
        .addConverterFactory(GsonConverterFactory.create()) // Va faire le parsing
        .build()
        .create(AuthenticatorApiService::class.java)

    suspend fun getCode() = apiService.getCode(6, 6, true).first()
}