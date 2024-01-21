package com.example.cashvault.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.UiMode
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cashvault.R
import com.example.cashvault.ui.theme.darkGray
import com.example.cashvault.ui.theme.gray
import com.example.cashvault.ui.theme.green
import com.example.cashvault.ui.theme.white
import com.example.cashvault.util.formatToPrice
import java.util.Locale

@Composable
fun TransactionItem(
    color: Color,
    description: String,
    value: Float,
    date: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.Start
        ){
            Text(
                description,
                fontWeight = FontWeight.SemiBold,
                color= white,
                fontSize = 16.sp
            )
            Text(
                date,
                fontWeight = FontWeight.Thin,
                color = darkGray,
                fontSize = 13.sp
            )
        }
        Text(
            value.formatToPrice(Locale.getDefault(),true),
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = color
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TransactionItemPreview() {
    TransactionItem(
        color = green,
        description = "Deposit",
        value = 21.89f,
        date = "12.01.2023 11:15",
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    )
}