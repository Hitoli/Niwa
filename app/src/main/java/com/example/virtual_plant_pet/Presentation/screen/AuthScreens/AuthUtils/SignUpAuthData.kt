package com.example.virtual_plant_pet.Presentation.screen.AuthScreens.AuthUtils

data class SignUpAuthData(
    val email: String,
    val password: String,
    val confirmPassword:String,
    val getConfirmPassword:(String)->Unit,
    val getPassword: (String) -> Unit,
    val getEmail: (String) -> Unit,
    val onSignUpNavigate: () -> Unit,
    val onLoginInNavigate: () -> Unit,
    val getSignUpPasswordExpose: Boolean,
    val getPasswordExpose: (Boolean) -> Unit,
    val getSignUpPasswordExpose2: Boolean,
    val getPasswordExpose2: (Boolean) -> Unit,
    val getGoogleSignUp:()->Unit,
    val facebookSignUp:()->Unit
)
