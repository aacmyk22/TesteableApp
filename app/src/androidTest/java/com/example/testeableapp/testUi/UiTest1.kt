package com.example.testeableapp.testUi

import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.testeableapp.ui.Screens.TipCalculatorScreen
import kotlin.math.ceil
import org.junit.Rule
import org.junit.Test

class UiTest1 {

    @get:Rule
    val composeRule = createComposeRule()

    /** Helper: espera hasta que el nodo exista o se agote el tiempo */
    private fun ComposeTestRule.waitUntilExists(node: SemanticsNodeInteraction) =
        waitUntil(3_000) { runCatching { node.fetchSemanticsNode() }.isSuccess }

    /** Helper: extrae el número (Double) del texto “Propina: $xx.xx” */
    private fun SemanticsNodeInteraction.valorPropina(): Double =
        fetchSemanticsNode()
            .config[SemanticsProperties.Text]            // lista AnnotatedString
            .joinToString()                              // a String
            .let { Regex("""\d+([.,]\d+)?""").find(it)!!.value.replace(',', '.').toDouble() }

    @Test
    fun prueba1() {
        composeRule.setContent { TipCalculatorScreen() }

        val montoField = composeRule.onAllNodes(hasSetTextAction())[0]
        montoField.performTextInput("100.5")

        val nodoTip = composeRule
            .onAllNodesWithText("Propina:", substring = true)
            .onFirst()
        composeRule.waitUntilExists(nodoTip)

        val valorAntes = nodoTip.valorPropina()

        composeRule.onNode(isToggleable()).performClick()

        composeRule.waitUntil(timeoutMillis = 4_000) {
            nodoTip.valorPropina() != valorAntes
        }
        val valorDespues = nodoTip.valorPropina()

        assert(valorDespues == ceil(valorAntes)) {
            "Se esperaba ${ceil(valorAntes)}, pero se obtuvo $valorDespues"
        }
    }
}
