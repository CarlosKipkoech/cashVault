package com.example.cashvault.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cashvault.ui.theme.white

@Composable
fun WalletOverview(
    valueBeforeComma:()->Int,
    valueAfterComma:()->Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Box(
            modifier = Modifier,
            contentAlignment = Alignment.BottomCenter
        ){

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {

                Text(
                    text = "Balance",
                    color = Color.DarkGray,
                    fontSize = 13.sp,
                )

                Row(
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.spacedBy(2.dp)
                ){
                    Text(
                        "${valueBeforeComma()}",
                        fontSize = 35.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        ",",
                        fontSize = 20.sp,
                        modifier = Modifier.offset(x = 0.dp, y = (-3.5).dp)
                    )
                    Text(
                        "%02d".format(valueAfterComma()),
                        fontSize = 20.sp,
                        modifier = Modifier.offset(x = 0.dp, y = (-3.5).dp)
                    )
                    Text(
                        "€",
                        fontSize = 18.sp,
                        modifier = Modifier.offset(x = 0.dp, y = (-3.5).dp)
                    )
                }
            }


        }

    }
}

@Preview
@Composable
fun WalletOverviewPreview(){
    WalletOverview(valueBeforeComma = {  500}, valueAfterComma = {5})
}