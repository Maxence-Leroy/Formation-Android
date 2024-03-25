package com.ragicorp.room.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ragicorp.room.Contact
import java.util.UUID

@Composable
fun AddContactView(
    modifier: Modifier = Modifier,
    onAddContact: (contact: Contact) -> Unit
) {
    val contactNameState = remember { mutableStateOf("") }
    val contactNumberState = remember { mutableStateOf("") }

    Surface(modifier = modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = contactNameState.value,
                onValueChange = { contactNameState.value = it },
                label = { Text(text = "Contact name") }
            )

            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = contactNumberState.value,
                onValueChange = { contactNumberState.value = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                label = { Text(text = "Contact phone number") }
            )

            Button(
                onClick = {
                    onAddContact(Contact(UUID.randomUUID(), contactNameState.value, contactNumberState.value))
                    contactNameState.value = ""
                    contactNumberState.value = ""
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue, contentColor = Color.White)
            ) {
                Text(
                    text = "Add contact",
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Preview
@Composable
fun AddContactPreview() {
    AddContactView(onAddContact = {})
}