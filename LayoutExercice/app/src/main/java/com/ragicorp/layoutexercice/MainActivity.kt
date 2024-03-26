package com.ragicorp.layoutexercice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ragicorp.layoutexercice.ui.theme.LayoutExerciceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.Gray
            ) {
                Column(
                    modifier = Modifier.padding(end = 16.dp, start = 8.dp, top = 18.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Row(modifier = Modifier
                        .offset(x = 32.dp, y = 46.dp)
                        .height(56.dp)) {
                        Box(modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Blue)) {
                            Text(modifier = Modifier.padding(8.dp).align(Alignment.CenterStart), text = "Hello", color = Color.White)
                        }
                    }
                }
            }
        }
    }
}