package com.ragicorp.room

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ragicorp.room.views.AddContactView
import com.ragicorp.room.views.ContactView
import java.util.UUID

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)

        setContent {
            val contacts = remember { mutableStateOf(listOf(Contact(UUID.randomUUID(), "a", "123"), Contact(
                UUID.randomUUID(), "b", "456"))) }
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.LightGray)
                    .padding(vertical = 8.dp)
                    .imePadding(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    AddContactView(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        onAddContact = { contact ->
                            contacts.value += contact
                        }
                    )
                }

                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(Color.Black)
                    )
                }

                items(contacts.value) { contact ->
                    ContactView(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        contact = contact,
                        onDelete = {
                            val contactList = contacts.value.toMutableList()
                            contactList.remove(contact)
                            contacts.value = contactList
                        }
                    )
                }
            }
        }
    }
}
