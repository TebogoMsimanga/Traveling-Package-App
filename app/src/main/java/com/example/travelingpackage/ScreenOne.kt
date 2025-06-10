package com.example.travelingpackage


import android.app.Activity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.travelingpackage.ui.components.AddingItems


@Composable
fun ScreenOne() {
    val context = LocalContext.current
    val activity = (context as? Activity)

    var showAddItemDialog by remember { mutableStateOf(false) }

    if (showAddItemDialog) {
        AddingItems (
            onAddItem = { newItem ->
                showAddItemDialog = false
            },
            onDismiss = {
                showAddItemDialog = false
            }
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Button(
            onClick = {
                showAddItemDialog = true
            }

        ) {
            Text(
                text = "Add to packing list"
            )
        }
        Spacer(
            modifier = Modifier.height(10.dp)
        )
        Button(
            onClick ={},
            modifier = Modifier.fillMaxWidth(),



            ) {
            Text(
                text = "Show packing list"
            )
        }
        Spacer(
            modifier = Modifier.height(10.dp)
        )
        Button(
            onClick ={
                activity?.finish()
            },
            modifier = Modifier.fillMaxWidth(),



            ) {
            Text(
                text = "Exit"
            )
        }
        Spacer(
            modifier = Modifier.height(8.dp)
        )


    }


}




@Preview
@Composable
fun ScreenOnePreview(){
    ScreenOne()

}