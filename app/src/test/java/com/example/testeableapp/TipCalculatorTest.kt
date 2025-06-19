package com.example.testeableapp

import org.junit.Assert.assertEquals
import org.junit.Test
import com.example.testeableapp.ui.Screens.calculateTip

class TipCalculatorTest {

    @Test
    fun testCalculateTip_20Percent_NoRoundUp() {
        val result = calculateTip(100.0, 20, false)
        assertEquals(20.0, result, 0.001)
    }

    @Test
    fun test15Percent_RoundUp() {
        val result = calculateTip(100.0, 15, true)
        assertEquals(15.0, result, 0.001)
    }

    @Test
    fun testCalculateNegativeAmount() {
        val result = calculateTip(-50.0, 20, false)
        assertEquals(-10.0, result, 0.001)
    }

    @Test
    fun testTotalPerson() {
        val bill = 100.0
        val tip = calculateTip(bill, 20, false)
        val people = 4
        val totalPerPerson = if (people > 0) (bill + tip) / people else 0.0
        assertEquals(30.0, totalPerPerson, 0.001)
    }



}
