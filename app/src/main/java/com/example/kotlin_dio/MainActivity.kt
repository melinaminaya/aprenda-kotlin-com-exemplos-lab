package com.example.kotlin_dio

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.ui.core.dp
import androidx.ui.layout.Column

@Preview
@Composable
fun MainActivity() {
    // Define a mutable list to hold items
    val itemList = remember { mutableStateListOf<String>() }

    // Define a state to hold the current item
    var currentItem by remember { mutableStateOf("") }

    // Column layout for the screen
    Column(modifier = Modifier.padding(16.dp)){

        // Text field to enter new item
        TextField(
            value = currentItem,
            onValueChange = { currentItem = it },
            label = { Text("Enter new item") },
            modifier = Modifier.fillMaxWidth()
        )

        // Button to add new item
        Button(
            onClick = {
                itemList.add(currentItem)
                currentItem = ""
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Add Item")
        }

        // Spacer
        Spacer(modifier = Modifier.height(16.dp))

        // LazyColumn to display items
        LazyColumn {
            items(itemList) { item ->
                Text(text = item, modifier = Modifier.padding(8.dp))
            }
        }
    }
}

