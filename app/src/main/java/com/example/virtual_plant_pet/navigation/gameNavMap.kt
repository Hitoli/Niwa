package com.example.virtual_plant_pet.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.solus.navigation.navUtils.navScreens
import com.example.virtual_plant_pet.screen.FightScreen

fun NavGraphBuilder.gameNavMap(navHostController: NavController, pad: PaddingValues) {
    navigation(
        startDestination = navScreens.FightScreen.route,
        route = navScreens.gameScreens.route
    ) {
        composable(navScreens.FightScreen.route) {
            FightScreen(pad = pad, onGameResult = {
                navHostController.navigate(navScreens.appNavScreen.route){
                    popUpTo(navScreens.FightScreen.route){
                        inclusive=true
                    }
                }
            })
        }
        composable(navScreens.appNavScreen.route) {
            appNavMap()
        }

    }
}