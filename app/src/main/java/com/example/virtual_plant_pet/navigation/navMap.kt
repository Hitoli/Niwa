package com.example.virtual_plant_pet.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.solus.navigation.navUtils.navScreens
import com.example.virtual_plant_pet.navigation.AuthNavMap
import com.example.virtual_plant_pet.navigation.appNavMap
import com.example.virtual_plant_pet.screen.FirstOnBoardingScreen
import com.example.virtual_plant_pet.screen.YourNameScreen
import com.example.virtual_plant_pet.screen.YourPetNameScreen

@Composable
fun navScreen(navaHostController: NavHostController) {
//    val viewModel = viewModel<MainViewModel>()

    NavHost(navController = navaHostController, startDestination = navScreens.authScreens.route) {
       //AuthScreen Navigation
        AuthNavMap(navaHostController)
        //BottomBar Navigation
        composable(navScreens.appNavScreen.route){
            appNavMap()
        }

        composable(navScreens.OnBoardingScreen.route){
            FirstOnBoardingScreen {
                navaHostController.navigate(navScreens.PetNameScreen.route)
            }
        }

        composable(navScreens.PetNameScreen.route){
            YourPetNameScreen(onNavigate = {
                navaHostController.navigate(navScreens.UserNameScreen.route)
            })
        }
        composable(navScreens.UserNameScreen.route){
            YourNameScreen(onNavigate = {
                navaHostController.navigate(navScreens.appNavScreen.route){
                    popUpTo(navScreens.PetNameScreen.route){
                        inclusive = true
                    }
                }

            })
        }

    }
}