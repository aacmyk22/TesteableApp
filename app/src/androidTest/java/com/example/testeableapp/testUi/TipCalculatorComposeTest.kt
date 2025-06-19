package com.example.testeableapp.testUi

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.*
import com.example.testeableapp.MainActivity
import org.junit.Rule
import org.junit.Test

class TipCalculatorComposeTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun emptyAmountShowsZeroTip() {
        composeRule.onNodeWithTag("amountInput").performTextClearance()
        composeRule.onNodeWithTag("tipResult").assertTextContains("Propina: $0.00")
    }


    @Test
    fun switchRetainsStateAfterCalculation() {
        composeRule.onNodeWithTag("roundUpSwitch").performClick()
        composeRule.onNodeWithTag("amountInput").performTextInput("100")
        composeRule.onNodeWithTag("roundUpSwitch").assertIsOn()
    }
}



















