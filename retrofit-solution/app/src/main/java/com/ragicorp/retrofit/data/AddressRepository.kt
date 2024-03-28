package com.ragicorp.retrofit.data

import com.ragicorp.retrofit.data.api.AddressApiService
import com.ragicorp.retrofit.data.api.ApiDataSource
import com.ragicorp.retrofit.data.api.toDomain
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AddressRepository {
    private val apiDataSource = ApiDataSource()

    suspend fun getAddressSuggestion(query: String): List<PlaceDomain> {
        return apiDataSource.getAddressSuggestion(query)
    }
}