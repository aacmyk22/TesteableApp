package com.example.testeableapp

object UserValidator {
    fun isValidUsername(username: String): Boolean {
        return username.isNotBlank() && username.length >= 3
    }
}