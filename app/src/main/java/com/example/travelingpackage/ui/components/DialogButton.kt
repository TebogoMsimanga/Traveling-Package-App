package com.example.travelingpackage.ui.components


import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

class DialogButton {
    @SuppressLint("NotConstructor")
    @Composable
    fun DialogButton() {

        var showAddItemDialog by remember { mutableStateOf(false) }


        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

        }
        Button(
            onClick = { showAddItemDialog = true }) {
            if (showAddItemDialog) {
                AddingItems(
                    onAddItem = { newItem ->
                        showAddItemDialog = false
                    },
                    onDismiss = {
                        showAddItemDialog = false
                    }
                )
            }

        }


    }
}

