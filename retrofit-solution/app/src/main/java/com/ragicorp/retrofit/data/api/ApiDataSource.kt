package com.ragicorp.retrofit.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiDataSource {
    private val addressApiService = Retrofit.Builder()
        .baseUrl("https://photon.komoot.io/")
        .addConverterFactory(GsonConverterFactory.create()) // Va faire le parsing
        .build()
        .create(AddressApiService::class.java)

    suspend fun getAddressSuggestion(query: String) =
        addressApiService
        .searchAddressNoCoordinates(query)
        .toDomain()
}