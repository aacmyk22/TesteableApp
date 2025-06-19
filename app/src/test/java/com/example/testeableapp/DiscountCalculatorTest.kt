package com.example.testeableapp

import org.junit.Assert.*
import org.junit.Test

class UserValidatorTest {

    @Test
    fun testValidUsername() {
        val result = UserValidator.isValidUsername("Orlando")
        assertTrue(result)
    }

    @Test
    fun testInvalidUsername_Empty() {
        val result = UserValidator.isValidUsername("")
        assertFalse(result)
    }

    @Test
    fun testInvalidUsername_Short() {
        val result = UserValidator.isValidUsername("ab")
        assertFalse(result)
    }
}