package com.example.virtual_plant_pet.Presentation.screen.AuthScreens.AuthUtils

data class AuthData(
    val getEmail: String,
    val getPassword: String,
    val getPasswordExpose: Boolean,
    val onSignUp: () -> Unit,
    val onNavigateLoginScreen: () -> Unit,
    val onEmail: (String) -> Unit,
    val onPassword: (String) -> Unit,
    val onGoogleLogin:()->Unit,
    val onFacebookLogin:()->Unit,
    val onPasswordExpose:(Boolean)->Unit,
    val onForgotPassword:()->Unit
)
