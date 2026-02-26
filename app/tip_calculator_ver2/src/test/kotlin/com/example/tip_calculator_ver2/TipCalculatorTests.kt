package com.example.tip_calculator_ver2

import org.junit.Assert.assertEquals
import org.junit.Test

class TipCalculatorTests {

    @Test
    fun calculateTip_20PercentNoRoundup() {
        val amount = 10.00
        val tipPercent = 20.00
        val expectedTip = java.text.NumberFormat.getCurrencyInstance().format(2)
        val actualTip = calculateTip(amount = amount, tipPercent = tipPercent, false)
        assertEquals(expectedTip, actualTip)

    }

    @Test
    fun calculateTip_20PercentRoundup() {
        val amount = 15.80
        val tipPercent = 20.00
        val expectedTip = java.text.NumberFormat.getCurrencyInstance().format(4)
        val actualTip = calculateTip(amount = amount, tipPercent = tipPercent, true)
        assertEquals(expectedTip, actualTip)

    }
}