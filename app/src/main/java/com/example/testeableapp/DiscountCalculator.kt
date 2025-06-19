package com.example.testeableapp

object DiscountCalculator {
    fun applyDiscount(price: Double, percentage: Int): Double {
        if (percentage !in 0..100) throw IllegalArgumentException("Porcentaje inválido")
        return price * (1 - percentage / 100.0)
    }
}