package com.ragicorp.authenticator

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
import com.ragicorp.authenticator.authenticator.AuthenticatorView
import com.ragicorp.authenticator.authenticator.AuthenticatorViewModel
import com.ragicorp.authenticator.ui.theme.AuthenticatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = AuthenticatorViewModel()
        setContent {
            AuthenticatorTheme {
                AuthenticatorView(viewModel = viewModel)
            }
        }
    }
}
