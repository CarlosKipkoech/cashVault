package com.example.cashvault.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.cashvault.ui.theme.orange
import com.example.cashvault.ui.theme.white


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransactionDialog(
    onDismiss: () -> Unit,
    value: () -> String,
    onValueChange: (String) -> Unit,
    description: String,
    isButtonEnabled: ()-> Boolean,
    onConfirmButton: () -> Unit
) {

    Dialog(onDismissRequest = { onDismiss }) {

        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 5.dp
            ),
            modifier = Modifier
                .fillMaxWidth()
        ) {

            CompositionLocalProvider(
                LocalTextSelectionColors provides TextSelectionColors(
                    handleColor = orange,
                    backgroundColor = Color.Transparent
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {

                    OutlinedTextField(
                        value = value(),
                        onValueChange = {
                            onValueChange(it)
                        },
                        textStyle = MaterialTheme.typography.bodyMedium,
                        label = {
                            Text(description)
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            cursorColor = orange,
                            focusedIndicatorColor = orange,
                            focusedLabelColor = orange
                        ),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                    )
                    Button(
                        onClick = {
                            onConfirmButton()
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = orange,
                            contentColor = white
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        shape = CircleShape,
                        enabled = isButtonEnabled()
                    ) {
                        Text(
                            text = "Confirm",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                        )
                    }
                }
            }


        }

    }

}