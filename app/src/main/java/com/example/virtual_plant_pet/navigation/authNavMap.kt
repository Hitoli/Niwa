package com.example.virtual_plant_pet.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.solus.navigation.navUtils.navScreens
import com.example.virtual_plant_pet.screen.LoginScreen
import com.example.virtual_plant_pet.screen.SignIn
import com.example.virtual_plant_pet.screen.SignUpScreen


fun NavGraphBuilder.AuthNavMap(navaHostController: NavController) {
    navigation(startDestination = navScreens.StartInScreen.route, route = navScreens.authScreens.route){
        composable(navScreens.LoginScreen.route){
            LoginScreen(onClick = {
                navaHostController.navigate(navScreens.SignInScreen.route)
            }, onNavigate = {
                navaHostController.navigate(navScreens.OnBoardingScreen.route){
                    popUpTo(navScreens.authScreens.route){
                        inclusive=true
                    }

                }
            })
        }
        composable(navScreens.SignInScreen.route){
            SignUpScreen(onClick = {
                navaHostController.navigate(navScreens.OnBoardingScreen.route){
                    popUpTo(navScreens.authScreens.route){
                        inclusive=true
                    }
                }
            })
        }
        composable(navScreens.StartInScreen.route){
            SignIn(onSignIn = {
                navaHostController.navigate(navScreens.SignInScreen.route){
                    popUpTo(navScreens.StartInScreen.route){
                        inclusive = true
                    }
                }


            }, onLogin = {
                navaHostController.navigate(navScreens.LoginScreen.route){
                    popUpTo(navScreens.StartInScreen.route){
                        inclusive = true
                    }
                }

            })
        }
    }
}