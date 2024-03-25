package com.ragicorp.retrofit.data

import com.ragicorp.retrofit.data.api.AddressApiService
import com.ragicorp.retrofit.data.api.toDomain
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AddressRepository {
    private val addressApiService = Retrofit.Builder()
        .baseUrl("https://photon.komoot.io/")
        .addConverterFactory(GsonConverterFactory.create()) // Va faire le parsing
        .build()
        .create(AddressApiService::class.java)

    suspend fun getAddressSuggestion(query: String): List<PlaceDomain> {
        return addressApiService.searchAddressNoCoordinates(query).toDomain()
    }
}