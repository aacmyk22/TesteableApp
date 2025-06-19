package com.example.testeableapp.testUi

import androidx.compose.ui.semantics.SemanticsActions
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.hasSetTextAction
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.performSemanticsAction
import androidx.compose.ui.test.performTextInput
import com.example.testeableapp.ui.Screens.TipCalculatorScreen
import org.junit.Rule
import org.junit.Test

class UiTest2 {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun prueba2() {
        composeTestRule.setContent { TipCalculatorScreen() }

        val input = composeTestRule.onAllNodes(hasSetTextAction())[0]
        input.performTextInput("100")

        val nodoPropina = composeTestRule
            .onAllNodesWithText("Propina:", substring = true)
            .onFirst()
        val textoAntes = nodoPropina
            .fetchSemanticsNode()
            .config[SemanticsProperties.Text]
            .joinToString()

        val slider = composeTestRule.onNode(
            SemanticsMatcher.Companion.keyIsDefined(SemanticsActions.SetProgress)
        )
        slider.performSemanticsAction(SemanticsActions.SetProgress) { it(0.20f) } // 20 %

        composeTestRule.waitForIdle()

        val textoDespues = nodoPropina
            .fetchSemanticsNode()
            .config[SemanticsProperties.Text]
            .joinToString()

        assert(textoDespues != textoAntes) {
            "La propina no cambió tras mover el slider (antes=$textoAntes, después=$textoDespues)"
        }
    }
}