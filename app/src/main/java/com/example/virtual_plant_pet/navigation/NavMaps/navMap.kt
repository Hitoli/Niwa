package com.example.virtual_plant_pet.navigation.NavMaps

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.solus.navigation.navUtils.navScreens
import com.example.virtual_plant_pet.Presentation.screen.OnBoardingScreen.FirstOnBoardingScreen
import com.example.virtual_plant_pet.Presentation.screen.OnBoardingScreen.SecondOnBoardinScreen
import com.example.virtual_plant_pet.Presentation.screen.OnBoardingScreen.YourNameScreen
import com.example.virtual_plant_pet.Presentation.screen.ViewModels.AuthViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun navScreen(navaHostController: NavHostController,viewModel: AuthViewModel = koinViewModel()) {

    NavHost(navController = navaHostController, startDestination = navScreens.OnBoardingScreen.route) {
       //AuthScreen Navigation
        authNavMap(navaHostController,viewModel)
        //BottomBar Navigation
        composable(navScreens.appNavScreen.route){
            appNavMap()
        }



        composable(navScreens.OnBoardingScreen.route){
            FirstOnBoardingScreen {
                navaHostController.navigate(navScreens.UserNameScreen.route){
                    popUpTo(navScreens.OnBoardingScreen.route){
                        inclusive = true
                    }
                }
            }
        }
        composable(navScreens.UserNameScreen.route){
            YourNameScreen(onNavigate = {
                navaHostController.navigate(navScreens.OnBoardingScreen2.route){
                    popUpTo(navScreens.UserNameScreen.route){
                        inclusive = true
                    }
                }

            })
        }
        composable(navScreens.OnBoardingScreen2.route){
            SecondOnBoardinScreen(onNavigatie = {
                navaHostController.navigate(navScreens.appNavScreen.route){
                    popUpTo(navScreens.OnBoardingScreen2.route){
                        inclusive = true
                    }
                }

            })
        }


    }
}