package com.ragicorp.room.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ragicorp.room.Contact
import java.util.UUID

@Composable
fun ContactView(
    modifier: Modifier = Modifier,
    contact: Contact,
    onDelete: () -> Unit
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = contact.name,
                    color = Color.Black,
                    fontSize = 16.sp
                )
                Text(
                    text = contact.phoneNumber,
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }

            Button(onClick = onDelete, colors = ButtonDefaults.buttonColors(containerColor = Color.Red, contentColor = Color.White)) {
                Text(
                    text = "Delete",
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Preview
@Composable
fun ContactPreview() {
    ContactView(
        contact = Contact(UUID.randomUUID(), "Toto", "+3312345678"),
        onDelete = {}
    )
}