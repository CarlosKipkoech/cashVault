package com.example.cashvault.presentation.state

import androidx.compose.ui.graphics.Color
import java.util.Date

data class TransactionUIItem(

    val amount: Float,
    val date: String,
    val description: String,
    val color: Color
)
