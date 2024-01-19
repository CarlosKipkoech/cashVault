package com.example.cashvault.domain

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

class ParseTransactionValueInputUseCase {

    // Checks using regular expression with value input by a user is valid

    operator fun invoke(value: String): Boolean {

        val decimalPointFormat = DecimalFormatSymbols.getInstance().decimalSeparator

        // handles cases like "10.00" or "5.0" and considers them valid
        val regexForNull = "0+$decimalPointFormat?[0]{0,2}"
        if(value.matches(Regex(regexForNull))){
            return false
        }

        val regexGeneral = "[0-9]*$decimalPointFormat?[0-9]{1,2}"
        return value.matches(Regex(regexGeneral))

    }
}