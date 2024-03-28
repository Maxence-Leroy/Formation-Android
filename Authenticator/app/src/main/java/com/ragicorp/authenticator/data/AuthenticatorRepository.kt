package com.ragicorp.authenticator.data

import com.ragicorp.authenticator.data.api.AuthenticatorDataSource

class AuthenticatorRepository {
    private val apiDataSource = AuthenticatorDataSource()

    suspend fun getCode() = apiDataSource.getCode()
}