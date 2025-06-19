package com.example.testeableapp

import org.junit.Assert.*
import org.junit.Test

class DiscountCalculatorTest {

    @Test
    fun testValidDiscount() {
        val result = DiscountCalculator.applyDiscount(100.0, 20)
        assertEquals(80.0, result, 0.01)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testInvalidDiscountPercentage() {
        DiscountCalculator.applyDiscount(100.0, 150)
    }
}