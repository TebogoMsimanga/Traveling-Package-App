package com.example.travelingpackage.ui.components


import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun Button(
    onClick: () -> Unit
){
    Button(
        onClick = {onClick}
    ) {
        Text(
            text = "Open"
        )
    }

}