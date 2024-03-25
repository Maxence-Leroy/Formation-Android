package com.ragicorp.retrofit.address_search.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ragicorp.retrofit.data.PlaceDomain

@Composable
fun AddressItem(
    place: PlaceDomain,
    onClick: (PlaceDomain) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        color = MaterialTheme.colorScheme.primary,
        shape = RoundedCornerShape(16.dp),
        onClick = { onClick(place) }
    ) {
        Text(
            modifier = Modifier.padding(8.dp),
            text = place.address
        )
    }
}