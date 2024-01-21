package com.example.cashvault.presentation.state

import com.example.cashvault.presentation.types.TransactionType

class DepositWithdrawDialogState {
    val isConfirmButtonEnabled: Boolean = false
    val inputValue: String = ""
    val transactionType: TransactionType = TransactionType.Deposit
    val isOpen: Boolean = false
}