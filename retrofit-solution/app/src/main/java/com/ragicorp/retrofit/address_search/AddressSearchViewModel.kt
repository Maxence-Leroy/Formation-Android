package com.ragicorp.retrofit.address_search

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ragicorp.retrofit.data.AddressRepository
import com.ragicorp.retrofit.data.PlaceDomain
import kotlinx.coroutines.launch

sealed class RequestState {
    data object Loading: RequestState()
    class Error(val t: Throwable): RequestState()
    class Success(val data: List<PlaceDomain>): RequestState()
}

class AddressSearchViewModel: ViewModel() {
    private val repository = AddressRepository()

    val searchField = mutableStateOf("")
    val searchResult = mutableStateOf<RequestState>(RequestState.Success(emptyList()))
    val coordinates = mutableStateOf("")

    fun updateSearchField(text: String) {
        searchField.value = text
    }

    fun searchAddress() {
        viewModelScope.launch {
            searchResult.value = RequestState.Loading
            try {
                val query = searchField.value
                val result = repository.getAddressSuggestion(query)
                searchResult.value = RequestState.Success(result)
            } catch (t: Throwable) {
                searchResult.value = RequestState.Error(t)
            }
        }
    }

    fun selectAddress(address: PlaceDomain) {
        coordinates.value = "${address.lat} ${address.long}"
    }
}