package com.ragicorp.retrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ragicorp.retrofit.address_search.AddressSearchView
import com.ragicorp.retrofit.address_search.AddressSearchViewModel
import com.ragicorp.retrofit.ui.theme.RetrofitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = AddressSearchViewModel()
        setContent {
            RetrofitTheme {
                AddressSearchView(viewModel = viewModel)
            }
        }
    }
}
