package com.example.virtual_plant_pet.navigation.NavMaps

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.solus.navigation.navUtils.navScreens
import com.example.virtual_plant_pet.Presentation.screen.AuthScreens.AuthUtils.AuthData
import com.example.virtual_plant_pet.Presentation.screen.AuthScreens.AuthUtils.SignUpAuthData
import com.example.virtual_plant_pet.Presentation.screen.AuthScreens.ForgotPasswordScreen
import com.example.virtual_plant_pet.Presentation.screen.AuthScreens.LoginScreen
import com.example.virtual_plant_pet.Presentation.screen.AuthScreens.SignIn
import com.example.virtual_plant_pet.Presentation.screen.AuthScreens.SignUpScreen
import com.example.virtual_plant_pet.Presentation.screen.ViewModels.AuthViewModel
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background3


fun NavGraphBuilder.authNavMap(navaHostController: NavController, viewModel: AuthViewModel) {
    navigation(
        startDestination = navScreens.StartInScreen.route,
        route = navScreens.authScreens.route
    ) {
        composable(navScreens.LoginScreen.route) {
            var getPasswordExpose by remember {
                mutableStateOf(false)
            }
            var getPassword by remember {
                mutableStateOf("")
            }
            var getEmail by remember {
                mutableStateOf("")
            }
            LoginScreen(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.linearGradient(
                            colors = listOf(virtual_plant_background, virtual_plant_background3),
                            start = Offset(Float.POSITIVE_INFINITY, 0f),
                            end = Offset(0f, Float.POSITIVE_INFINITY)
                        )
                    ), authData = AuthData(
                    getEmail = getEmail,
                    getPassword = getPassword,
                    getPasswordExpose = getPasswordExpose,
                    onEmail = {
                        getEmail = it
                    },
                    onSignUp = {
                        navaHostController.navigate(navScreens.SignInScreen.route)
                    },
                    onFacebookLogin = {},
                    onGoogleLogin = {},
                    onNavigateLoginScreen = {
                        navaHostController.navigate(navScreens.OnBoardingScreen.route) {
                            popUpTo(navScreens.authScreens.route) {
                                inclusive = true
                            }
                        }
                    },
                    onPassword = {
                        getPassword = it
                    },
                    onPasswordExpose = {
                        getPasswordExpose = it
                    }, onForgotPassword = {
                        navaHostController.navigate(navScreens.ForgotPasswordScreen.route)
                    })
            )
        }
        composable(navScreens.SignInScreen.route) {
            var getPasswordExpose by remember {
                mutableStateOf(false)
            }
            var getPasswordExpose2 by remember {
                mutableStateOf(false)
            }

            var getPassword by remember {
                mutableStateOf("")
            }
            var getConfirmPassword by remember {
                mutableStateOf("")
            }
            var getEmail by remember {
                mutableStateOf("")
            }
            SignUpScreen(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.linearGradient(
                        colors = listOf(virtual_plant_background, virtual_plant_background3),
                        start = Offset(Float.POSITIVE_INFINITY, 0f),
                        end = Offset(0f, Float.POSITIVE_INFINITY)
                    )
                ), signUpAuthData = SignUpAuthData(
                email = getEmail,
                password = getPassword,
                confirmPassword = getConfirmPassword,
                getConfirmPassword = {
                    getConfirmPassword = it
                },
                getPassword = {
                    getPassword = it
                },
                getEmail = { getEmail = it },
                getGoogleSignUp = {},
                getPasswordExpose = {
                    getPasswordExpose = it
                },
                getPasswordExpose2 = {
                    getPasswordExpose2 = it
                },
                getSignUpPasswordExpose = getPasswordExpose,
                facebookSignUp = {},
                onSignUpNavigate = {
                    navaHostController.navigate(navScreens.OnBoardingScreen.route) {
                        popUpTo(navScreens.authScreens.route) {
                            inclusive = true
                        }
                    }
                },
                getSignUpPasswordExpose2 = getPasswordExpose2, onLoginInNavigate = {
                    navaHostController.navigate(navScreens.LoginScreen.route)

                }
            ))
        }
        composable(navScreens.ForgotPasswordScreen.route) {
            var forgotPassword by remember{
                mutableStateOf("")
            }


            ForgotPasswordScreen(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.linearGradient(
                        colors = listOf(virtual_plant_background, virtual_plant_background3),
                        start = Offset(Float.POSITIVE_INFINITY, 0f),
                        end = Offset(0f, Float.POSITIVE_INFINITY)
                    )
                ), onForgot = {
                navaHostController.navigate(navScreens.LoginScreen.route) {
                    popUpTo(navScreens.ForgotPasswordScreen.route) {
                        inclusive = true
                    }
                }

            }, forgotPassword = forgotPassword, onForgotPassword = {
                forgotPassword = it
            })
        }
        composable(navScreens.StartInScreen.route) {
            SignIn(onSignIn = {
                navaHostController.navigate(navScreens.SignInScreen.route) {
                    popUpTo(navScreens.StartInScreen.route) {
                        inclusive = true
                    }
                }


            }, onLogin = {
                navaHostController.navigate(navScreens.LoginScreen.route) {
                    popUpTo(navScreens.StartInScreen.route) {
                        inclusive = true
                    }
                }

            })
        }
    }
}