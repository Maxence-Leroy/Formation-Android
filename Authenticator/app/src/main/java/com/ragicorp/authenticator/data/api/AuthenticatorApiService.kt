package com.ragicorp.authenticator.data.api

import retrofit2.http.GET
import retrofit2.http.Query

interface AuthenticatorApiService {
    @GET("api/v1.0/randomstring?count=1&")
    suspend fun getCode(@Query("min") min: Int, @Query("max") max: Int, @Query("all") includeNumberAndSymbols: Boolean): List<String>
}