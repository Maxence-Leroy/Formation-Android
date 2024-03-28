package com.ragicorp.retrofit.address_search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ragicorp.retrofit.address_search.views.AddressItem

@Composable
fun AddressSearchView(
    viewModel: AddressSearchViewModel
) {
    val searchField = remember { viewModel.searchField }
    val searchResult = remember { viewModel.searchResult }
    val coordinates = remember { viewModel.coordinates }
    Surface(modifier = Modifier
        .fillMaxSize()
        .imePadding()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = searchField.value,
                    onValueChange = { viewModel.updateSearchField(it) },
                    placeholder = { Text("Address") }
                )

                Button(onClick = { viewModel.searchAddress() }) {
                    Text("Search")
                }
            }

            when (val searchResultValue = searchResult.value) {
                is RequestState.Loading -> CircularProgressIndicator(modifier = Modifier.size(48.dp))
                is RequestState.Error -> Text("Error: ${searchResultValue.t.localizedMessage}")
                is RequestState.Success -> LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f, fill = true),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(searchResultValue.data) {
                        AddressItem(
                            place = it,
                            onClick = { place -> viewModel.selectAddress(place) }
                        )
                    }
                }
            }


            Text(text = coordinates.value)
        }
    }

}