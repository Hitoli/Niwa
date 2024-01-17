package com.example.virtual_plant_pet.navigation.NavMaps

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.solus.navigation.navUtils.navScreens
import com.example.virtual_plant_pet.Presentation.screen.HomeScreen.FightSequenceScreens.FightScreen
import com.example.virtual_plant_pet.Presentation.screen.HomeScreen.FightSequenceScreens.FightScreenSeq
import com.example.virtual_plant_pet.Presentation.screen.HomeScreen.OnBoardingForFightScreen
import com.example.virtual_plant_pet.Presentation.screen.HomeScreen.StartFightScreen
import com.example.virtual_plant_pet.Presentation.screen.HomeScreen.StealSequenceScreens.ResultScreen
import com.example.virtual_plant_pet.Presentation.screen.HomeScreen.StealSequenceScreens.StealScreen


fun NavGraphBuilder.gameNavMap(navHostController: NavController, pad: PaddingValues,getAppNavMap:()->Unit) {
    navigation(
        startDestination = navScreens.StartFightScreen.route,
        route = navScreens.gameScreens.route
    ) {
        composable(navScreens.StartFightScreen.route){
            StartFightScreen(onFightFind = {
                navHostController.navigate(navScreens.OnBoardingFightScreen.route){
                    popUpTo(navScreens.StartFightScreen.route){
                        inclusive=true
                    }
                }
            })
        }
        composable(navScreens.OnBoardingFightScreen.route){
            OnBoardingForFightScreen(onFight = {
                navHostController.navigate(navScreens.FightScreen.route){
                    popUpTo(navScreens.OnBoardingFightScreen.route){
                        inclusive=true
                    }
                }
            }, pad = pad, Screen = "Fight")
        }

        composable(navScreens.ResultScreen.route){
            ResultScreen()
        }
        composable(navScreens.StealScreen.route){
            StealScreen(onCapture ={
                i, b ->  
            })
        }
        composable(navScreens.FightScreen.route) {
            var isOnVisible by remember {
                mutableStateOf(false)
            }
            var AttackingPlant by remember {
                mutableStateOf("Fight")
            }
            var onFightPressed by remember {
                mutableStateOf(false)
            }
            var onTotalAmountPlant1 by remember {
                mutableStateOf(120)
            }
            var onUsedAmountPlant1 by remember {
                mutableStateOf(0)
            }
            var onTotalAmountPlant2 by remember {
                mutableStateOf(120)
            }
            var onUsedAmountPlant2 by remember {
                mutableStateOf(0)
            }
            var onResourceAmount by remember {
                mutableStateOf(0)
            }

    if (onUsedAmountPlant1 >= onTotalAmountPlant1) {
        isOnVisible = true
    }
            if (onUsedAmountPlant2 >= onTotalAmountPlant2) {
                isOnVisible = true
            }
            FightScreenSeq(isPad = pad, onGameResult = {
               getAppNavMap()
            }, onFight = {
                    onFightPressed = it
                },
                onUsedAmountPlant1 = {
                    onUsedAmountPlant1 += it
                },
                isOnFightPressed = onFightPressed,
                totalHealthAmountPlant1 = onTotalAmountPlant1,
                usedHealthAmountPlant1 = onUsedAmountPlant1, onUsedAmountPlant2 = {}, usedHealthAmountPlant2 =onUsedAmountPlant2 , totalHealthAmountPlant2 =onTotalAmountPlant2, resourceTotalAmount = onResourceAmount, resourceAmount = onTotalAmountPlant1, onresourceAmount = {
                    onResourceAmount+=it
                })
//            FightScreen(isPad = pad, onGameResult = {
//               getAppNavMap()
//            }, onFight = {
//                    onFightPressed = it
//                },
//                onAttack = {
//                    AttackingPlant = it
//                },
//                onUsedAmountPlant1 = {
//                    onUsedAmountPlant1 += it
//                },
//                isOnFightPressed = onFightPressed,
//                isOnAttackingPlant = AttackingPlant,
//                isOnVisible = isOnVisible,
//                totalHealthAmountPlant1 = onTotalAmountPlant1,
//                usedHealthAmountPlant1 = onUsedAmountPlant1,
//                onVisible = {
//                    isOnVisible = it
//                }, onUsedAmountPlant2 = {}, usedHealthAmountPlant2 =onUsedAmountPlant2 , totalHealthAmountPlant2 =onTotalAmountPlant2)
        }
//        composable(navScreens.appNavScreen.route) {
//            appNavMap()
//        }

    }
}