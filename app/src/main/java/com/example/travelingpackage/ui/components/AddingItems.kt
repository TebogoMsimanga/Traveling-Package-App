package com.example.travelingpackage.ui.components


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.travelingpackage.ui.logic.PackingItem


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddingItems(
    onDismiss: () -> Unit, // CLosing AlertDialog
    onAddItem: (PackingItem) -> Unit // Adding Items

) {

    //variables for storing data that can change
    var itemName by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var quantity by remember { mutableStateOf("") }
    var comment by remember { mutableStateOf("") }

    //variables for storing errors
    var itemNameError by remember { mutableStateOf<String?>(null) }
    var categoryError by remember { mutableStateOf<String?>(null) }
    var quantityError by remember { mutableStateOf<String?>(null) }
    var commentError by remember { mutableStateOf<String?>(null) }


    AlertDialog(
        onDismissRequest = onDismiss,
    ) {
        Surface {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            )

            {
                OutlinedTextField(
                    value = itemName,
                    onValueChange = {
                        itemName = it;
                        itemNameError = null
                    },
                    label = { Text("Item Name") },
                    isError = itemNameError != null,
                    modifier = Modifier
                        .fillMaxWidth()
                )

                itemNameError?.let {
                    Text(
                        text = it,
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier.padding(16.dp)
                    )

                }
                Spacer(
                    modifier = Modifier.padding(8.dp)
                )

                OutlinedTextField(
                    value = category,
                    onValueChange = {
                        category = it;
                        categoryError = null
                    },
                    label = { Text("Category") },
                    isError = categoryError != null,
                    modifier = Modifier
                        .fillMaxWidth()
                )

                categoryError?.let {
                    Text(
                        it,
                        color = MaterialTheme.colorScheme.error,

                        )
                }
                Spacer(
                    modifier = Modifier.padding(8.dp)

                )
                OutlinedTextField(
                    value = quantity,
                    onValueChange = {
                        quantity = it;
                        quantityError = null
                    },
                    label = { Text("Quantity") },
                    isError = quantityError != null,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)

                )
                quantityError ?.let {
                    Text(
                        it,
                        color=MaterialTheme.colorScheme.error
                    )
                }
                Spacer(
                    modifier = Modifier.padding(8.dp)
                )
                OutlinedTextField(
                    value = comment,
                    onValueChange = {
                        comment = it;
                        commentError = null
                    },
                    label = { Text("Comment") },
                    isError = commentError != null,
                    modifier = Modifier
                        .fillMaxWidth()
                )

                commentError?.let {
                    Text(
                        it,
                        color = MaterialTheme.colorScheme.error,

                        )

                }

                Row {
                    Button(
                        onClick = {
                            itemNameError = null
                            categoryError = null
                            quantityError =null
                            commentError = null

                            var isValid = true
                            if (itemName.isBlank()) {
                                itemNameError = "Name field is empty"
                                isValid = false

                            }
                            if (category.isBlank()){
                                categoryError = "category field is empty"
                                isValid = false
                            }
                            //convert user input to number
                            val intQuantity = quantity.toIntOrNull()
                            // if the user does not input anything then display error massage
                            // user input must always be a positive number
                            if (intQuantity == null || intQuantity <= 0){
                                quantityError = "quantity field is empty"
                                isValid = false


                            }
                            if (comment. isBlank()){
                                commentError = "comment field is empty"
                                isValid = false
                            }
                            if (isValid) {
                                onAddItem(
                                    PackingItem(
                                        name = itemName,
                                        category = category,
                                        // this field only accepts positive numbers
                                        //app fails to process if its not a positive number
                                        quantity = intQuantity ?: 0,
                                        comment = comment
                                    )
                                )
                                onDismiss()
                            }
                        },
                        colors = ButtonDefaults.buttonColors(Color.Green)
                    ) {
                        Text(text = "ADD")


                    }
                    Spacer(modifier = Modifier.padding(10.dp))

                    Button(
                        onClick = onDismiss,
                        colors = ButtonDefaults.buttonColors(Color.Red)


                    ) {
                        Text(text = "CANCEL")

                    }
                    Spacer(modifier = Modifier.padding(10.dp))
                }



            }



        }
    }
}





@Preview(showBackground = true)
@Composable
fun AddingItemsPreview() {
    AddingItems(
        onDismiss = {},
        onAddItem = {}

    )

}
