package com.ragicorp.retrofit.address_search

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ragicorp.retrofit.data.AddressRepository
import com.ragicorp.retrofit.data.PlaceDomain
import kotlinx.coroutines.launch

class AddressSearchViewModel: ViewModel() {
    private val repository = AddressRepository()

    val searchField = mutableStateOf("")
    val searchResult = mutableStateOf<List<PlaceDomain>>(emptyList())
    val coordinates = mutableStateOf("")

    fun updateSearchField(text: String) {
        searchField.value = text
    }

    fun searchAddress() {
        viewModelScope.launch {
            searchResult.value = repository.getAddressSuggestion(searchField.value)
        }
    }

    fun selectAddress(address: PlaceDomain) {
        coordinates.value = "${address.lat} ${address.long}"
    }
}