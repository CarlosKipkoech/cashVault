package com.example.cashvault.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CalculateListSumUseCaseTest {

    private val calculateListSumUseCase = CalculateListSumUseCase()

    @Test
    fun testResultWithEmptyListIsZero(){
        var result = calculateListSumUseCase(emptyList())
        assertThat(result).isEqualTo(0f)
    }

    @Test
    fun testResultWithOneElem(){
        var result = calculateListSumUseCase(listOf(2.3f))
        assertThat(result).isEqualTo(2.3f)
    }

    @Test
    fun testResultWithMultipleIsCorrect(){
        var result = calculateListSumUseCase(listOf(2.3f,4.5f,6.8f))
        assertThat(result).isEqualTo(13.6f)
    }
}