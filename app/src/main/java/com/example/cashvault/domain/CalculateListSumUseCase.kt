package com.example.cashvault.domain

class CalculateListSumUseCase {

    // calculates the sum in list.

    operator fun invoke (list: List<Float>): Float {
        var result = 0f

        for (elem in list){
            result+=elem
        }

        return  result

    }
}