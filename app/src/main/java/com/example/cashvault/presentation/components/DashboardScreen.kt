package com.example.cashvault.presentation.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cashvault.R
import com.example.cashvault.presentation.components.ui.theme.CashVaultTheme
import com.example.cashvault.ui.theme.white


@Composable
fun DashboardScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        userProfileSection()

        currentBalSection()

        DepositWithdrawButtons()

        creditCardSection()

        previousTransactionsSection()
    }

}


@Composable
fun userProfileSection() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Image(
            painter = painterResource(id = R.drawable.mypic), contentDescription = null,
            modifier = Modifier
                .size(43.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary
        )
    }

}

@Composable
fun currentBalSection() {

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
        Spacer(modifier = Modifier.height(3.dp))

        Text(
            text = "$1000.00",
            color = Color.Black,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )

    }
}

@Composable
fun DepositWithdrawButtons() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        TransactionButton(
            text = "Deposit",
            icon = Icons.Default.KeyboardArrowDown,
            backgroundColor = Color.DarkGray,
            contentColor = Color.Black,
            onButtonClick = { /*TODO*/ },
            modifier = Modifier
        )

        Spacer(modifier = Modifier.width(17.dp))


        TransactionButton(
            text = "Withdraw",
            icon = Icons.Default.KeyboardArrowUp,
            backgroundColor = Color.DarkGray,
            contentColor = Color.Black,
            onButtonClick = { /*TODO*/ },
            modifier = Modifier
        )
    }

}

@Composable
fun creditCardSection() {


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1.35f)
    ) {

        Column(modifier = Modifier.fillMaxWidth()) {

            Text(
                text = "Cards",
                color = Color.DarkGray,
                fontSize = 13.sp,
            )

            Image(
                painter = painterResource(id = R.drawable.visacard), // Replace with your actual image resource
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(16.dp))
            )

        }
    }
}

@Composable
fun previousTransactionsSection(){


}





//@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    DashboardScreen()
}