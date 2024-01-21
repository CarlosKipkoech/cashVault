package com.example.cashvault.presentation.components

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.cashvault.domain.CalculateListSumUseCase
import com.example.cashvault.domain.ParseTransactionValueInputUseCase
import com.example.cashvault.presentation.state.DepositWithdrawDialogState
import com.example.cashvault.presentation.state.TransactionUIItem
import com.example.cashvault.presentation.types.TransactionType
import com.example.cashvault.ui.theme.green
import com.example.cashvault.ui.theme.redOrange
import java.util.Date
import kotlin.math.absoluteValue
import kotlin.math.roundToInt

class WalletViewModel: ViewModel() {

    var dialogState by mutableStateOf(DepositWithdrawDialogState())
    private  set

    var totalAmountBeforeComma by mutableStateOf(0)
        private  set
    var totalAmountAfterComma by mutableStateOf(0)
        private  set

    val transactionList = mutableStateListOf<TransactionUIItem>()

    private val parseTransactionValueInputUseCase = ParseTransactionValueInputUseCase()
    private val calculateListSumUseCase = CalculateListSumUseCase()

    fun onDepositClick(){
        dialogState = dialogState.copy(
            isOpen = true, transactionType = TransactionType.Deposit
        )
    }

    fun onWithdrawClick(){
        dialogState = dialogState.copy(
            isOpen = true, transactionType = TransactionType.Withdraw
        )
    }

    fun onDismissDialog(){
        dialogState = DepositWithdrawDialogState()
    }

    fun onTransactionValueChange(newValue: String){
        val validationResult = parseTransactionValueInputUseCase(newValue)
        dialogState = dialogState.copy(inputValue = newValue)
        dialogState = dialogState.copy(isConfirmButtonEnabled = validationResult)
    }

    fun onTransactionConfirm() {
        val factor = if (dialogState.transactionType == TransactionType.Withdraw) -1 else 1
        val transactionFloatValue = dialogState.inputValue.toFloatOrNull()?.times(factor) ?: return

        val timestamp = System.currentTimeMillis()
        val date = Date(timestamp)

        val transactionUiItem = TransactionUIItem(
            description = if(dialogState.transactionType == TransactionType.Withdraw) "Withdraw" else "Deposit",
            amount = transactionFloatValue,
            date = date.toString(),
            color = if(dialogState.transactionType == TransactionType.Withdraw) redOrange else green
        )
        transactionList.add(transactionUiItem)
        setTotalAmount()
        onDismissDialog()
    }

    private fun setTotalAmount(){
        val totalAmount = calculateListSumUseCase(
            transactionList.map { it.amount }
        )
        val valueMultipliedWith10Pow2 = (totalAmount * 100).roundToInt()
        totalAmountBeforeComma = valueMultipliedWith10Pow2 / 100
        totalAmountAfterComma = valueMultipliedWith10Pow2.absoluteValue % 100
    }



}