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
    var song by remember { mutableStateOf("") }
    var artist by remember { mutableStateOf("") }
    var rating by remember { mutableStateOf("") }
    var comment by remember { mutableStateOf("") }

    //variables for storing errors
    var songError by remember { mutableStateOf<String?>(null) }
    var artistError by remember { mutableStateOf<String?>(null) }
    var ratingError by remember { mutableStateOf<String?>(null) }
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
                    value = song,
                    onValueChange = {
                        song = it;
                        songError = null
                    },
                    label = { Text("name") },
                    isError = songError != null,
                    modifier = Modifier
                        .fillMaxWidth()
                )

                songError?.let {
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
                    value = artist,
                    onValueChange = {
                        artist = it;
                        artistError = null
                    },
                    label = { Text("artist") },
                    isError = artistError != null,
                    modifier = Modifier
                        .fillMaxWidth()
                )

                artistError?.let {
                    Text(
                        it,
                        color = MaterialTheme.colorScheme.error,

                        )
                }
                Spacer(
                    modifier = Modifier.padding(8.dp)

                )
                OutlinedTextField(
                    value = rating,
                    onValueChange = {
                        rating = it;
                        ratingError = null
                    },
                    label = { Text("Rating") },
                    isError = ratingError != null,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)

                )
                ratingError ?.let {
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
                            songError = null
                            artistError =null
                            commentError = null

                            var isValid = true
                            if (song.isBlank()) {
                                songError = ""
                                isValid = false

                            }
                            if (artist.isBlank()){
                                artistError = "category field is empty"
                                isValid = false
                            }
                            //convert user input to number
                            val intRating = rating.toIntOrNull()
                            // if the user does not input anything then display error massage
                            // user input must always be a positive number
                            if (intRating == null || intRating <= 5){

                                isValid = false


                            }
                            if (comment. isBlank()){
                                commentError = "comment field is empty"
                                isValid = false
                            }
                            if (isValid) {
                                val intRating = null
                                onAddItem(
                                    PackingItem(
                                        song = song,
                                        artist = artist,
                                        // this field only accepts positive numbers
                                        //app fails to process if its not a positive number
                                        rating = intRating ?: 5,
                                        comment = comment,

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
