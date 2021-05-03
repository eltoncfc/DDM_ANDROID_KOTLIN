package com.Hair2u.Hair2uApp.ui.login

/**
 * Authentication result : success (user details) or error message.
 */
data class LoginResult(
        val success: LoginUsuario? = null,
        val error: Int? = null
)