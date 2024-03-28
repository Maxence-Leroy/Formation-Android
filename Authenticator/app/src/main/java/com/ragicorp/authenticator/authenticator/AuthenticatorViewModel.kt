package com.ragicorp.authenticator.authenticator

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ragicorp.authenticator.data.AuthenticatorRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

sealed class RequestStatus {
    data object Loading: RequestStatus()
    class Error(val t: Throwable): RequestStatus()
    class Success(val data: String): RequestStatus()
}

class AuthenticatorViewModel: ViewModel() {
    private val repository = AuthenticatorRepository()
    val state = mutableStateOf<RequestStatus>(RequestStatus.Loading)
    val currentDelay = mutableIntStateOf(0)

    suspend fun autoUpdateCode() {
        while(true) {
            (10_000 downTo 0 step 10).forEach { i ->
                currentDelay.intValue = i
                delay(10)
            }
            updateCode()
        }
    }

    private fun updateCode() {
        viewModelScope.launch {
            state.value = RequestStatus.Loading
            try {
                state.value = RequestStatus.Success(repository.getCode())
            } catch(t: Throwable) {
                state.value = RequestStatus.Error(t)
            }
        }
    }
}