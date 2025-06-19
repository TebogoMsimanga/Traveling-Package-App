package com.example.travelingpackage.ui.components


import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Button(
    onClick: () -> Unit,
    colors: ButtonColors,
    function: @Composable () -> Unit,
    modifier: Modifier
){
    Button(
        onClick = {onClick}
    ) {
        Text(
            text = "Open"
        )
    }

}