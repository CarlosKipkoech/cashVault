package com.example.cashvault

import TransactionItem
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cashvault.presentation.components.TransactionButton
import com.example.cashvault.presentation.components.UserProfileSection
import com.example.cashvault.presentation.components.WalletOverview
import com.example.cashvault.presentation.components.WalletViewModel
import com.example.cashvault.ui.theme.CashVaultTheme
import com.example.cashvault.ui.theme.darkBlue
import com.example.cashvault.ui.theme.white

class MainActivity : ComponentActivity() {

    private val walletViewModel = WalletViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CashVaultTheme {
                Box(
                    modifier = Modifier
                        .background(color = darkBlue)
                        .fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {

                        UserProfileSection()

                        WalletOverview(
                            valueBeforeComma = { walletViewModel.totalAmountBeforeComma },
                            valueAfterComma = { walletViewModel.totalAmountAfterComma })

                        DepositWithdrawButtons()

                        CreditCardSection()

                        PreviousTransactionsSection()
                    }
                }
            }
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
                onButtonClick = { walletViewModel.onDepositClick() },
                modifier = Modifier
            )

            Spacer(modifier = Modifier.width(17.dp))


            TransactionButton(
                text = "Withdraw",
                icon = Icons.Default.KeyboardArrowUp,
                backgroundColor = Color.DarkGray,
                contentColor = Color.Black,
                onButtonClick = { walletViewModel.onWithdrawClick() },
                modifier = Modifier
            )
        }

    }

    @Composable
    fun CreditCardSection() {


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
    fun PreviousTransactionsSection(){

        LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            itemsIndexed(walletViewModel.transactionList) { _, transaction ->
                TransactionItem(
                    color = transaction.color,
                    description = transaction.description,
                    value = transaction.amount,
                    date = transaction.date,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(white.copy(0.8f), RoundedCornerShape(25.dp))
                        .padding(12.dp)
                )
            }
        }

    }
    }

