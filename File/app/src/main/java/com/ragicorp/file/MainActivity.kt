package com.ragicorp.file

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import java.io.File

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val context = this

        val screenHeight = windowManager.defaultDisplay.height

        setContent {
            val fileList = remember { mutableStateOf(context.fileList().toList()) }
            val scrollState = rememberScrollState()
            val fileContent = remember { mutableStateOf("") }

            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.Gray
            ) {
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .imePadding()
                        .verticalScroll(scrollState),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    ListFiles(fileList = fileList.value, screenHeight = screenHeight, openFile = {
                        val file = File(context.filesDir, it)
                        fileContent.value = file.readText()
                    })

                    OutlinedTextField(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp), value = fileContent.value, onValueChange = {fileContent.value = it})

                    FileSaver(onSaveFile = {
                        val file = File(context.filesDir, it)
                        file.writeText(fileContent.value)
                        fileList.value = context.fileList().toList()
                    })
                }
            }
        }
    }
}

@Composable
fun ListFiles(fileList: List<String>, screenHeight: Int, openFile: (String) -> Unit) {
    with(LocalDensity.current) {
        LazyColumn(modifier = Modifier.padding(vertical = 4.dp).fillMaxWidth().heightIn(max = (screenHeight.toFloat() / 3f).toDp())) {
            items(fileList) { file ->
                FileSelector(file, onOpenFile = { openFile(file)})
            }
        }
    }
}

@Composable
fun FileSelector(fileName: String, onOpenFile: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = fileName)
        TextButton(
            onClick = onOpenFile
        ) {
            Text(text = "Open file")
        }
    }
}

@Composable
fun FileSaver(onSaveFile: (String) -> Unit) {
    val fileName = remember { mutableStateOf("") }

    Row(modifier = Modifier.padding(vertical = 4.dp)) {
        TextField(value = fileName.value, onValueChange = {fileName.value = it}, label = { Text(text = "File name")}, singleLine = true)
        TextButton(
            onClick = { onSaveFile(fileName.value) }
        ) {
            Text(text = "Save file")
        }
    }
}