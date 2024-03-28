package com.ragicorp.authenticator.authenticator

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AuthenticatorView(
    viewModel: AuthenticatorViewModel
) {
    val requestStatus = remember { viewModel.state }
    val currentDelay = remember { viewModel.currentDelay }
    val delayAnimation by animateFloatAsState(targetValue = currentDelay.intValue / 10_000f, label = "")

    LaunchedEffect(null) {
        viewModel.autoUpdateCode()
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.align(Alignment.Center)) {
                when (val requestStatusValue = requestStatus.value) {
                    is RequestStatus.Loading -> CircularProgressIndicator(modifier = Modifier.size(96.dp))
                    is RequestStatus.Error -> Text(requestStatusValue.t.localizedMessage ?: "Error")
                    is RequestStatus.Success -> Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            requestStatusValue.data,
                            style = MaterialTheme.typography.headlineLarge
                        )

                        CircularProgressIndicator(
                            modifier = Modifier.size(48.dp),
                            progress = delayAnimation
                        )
                    }
                }
            }
        }

    }
}