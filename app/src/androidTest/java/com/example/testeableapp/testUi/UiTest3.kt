package com.example.testeableapp.testUi

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.testeableapp.ui.Screens.TipCalculatorScreen
import org.junit.Rule
import org.junit.Test

class UiTest3 {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun prueba3() {
        composeTestRule.setContent { TipCalculatorScreen() }

        composeTestRule.onNodeWithText("Monto de la cuenta", useUnmergedTree = true)
            .assertIsDisplayed()

        composeTestRule.onNodeWithText("Porcentaje de propina:", substring = true)
            .assertIsDisplayed()

        composeTestRule.onNodeWithText("Número de personas:", substring = true)
            .assertIsDisplayed()
    }
}