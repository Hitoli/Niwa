package com.example.virtual_plant_pet.navigation.NavMaps

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.LaunchedEffect
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
import com.example.virtual_plant_pet.Presentation.screen.HomeScreen.HomeUtils.CardItem
import com.example.virtual_plant_pet.Presentation.screen.HomeScreen.OnBoardingForFightScreen
import com.example.virtual_plant_pet.Presentation.screen.HomeScreen.StartFightScreen
import com.example.virtual_plant_pet.Presentation.screen.HomeScreen.StealSequenceScreens.ResultScreen
import com.example.virtual_plant_pet.Presentation.screen.HomeScreen.StealSequenceScreens.StealScreen
import com.example.virtual_plant_pet.R
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds


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

            var timerTicks by remember{
                mutableStateOf(0)
            }



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
            var onTotalResourceAmount by remember {
                mutableStateOf(120)
            }
            var cardList = listOf<CardItem>(
                CardItem(cardImage = R.drawable.playingcardniwa1,5, 10),
                CardItem(cardImage = R.drawable.playingcardniwa1,5,10),
                CardItem(cardImage = R.drawable.playingcardniwa1,5,10),
                CardItem(cardImage = R.drawable.playingcardniwa1,5,10),
                CardItem(cardImage = R.drawable.playingcardniwa1,5,10),
                CardItem(cardImage = R.drawable.playingcardniwa1,5,10),
                CardItem(cardImage = R.drawable.playingcardniwa1,5,10),

                )
            LaunchedEffect(key1 = Unit){
                while (onResourceAmount<=onTotalResourceAmount){
                    delay(1.seconds)
                    timerTicks++;
                    onResourceAmount+=30;
                }
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
                usedHealthAmountPlant1 = onUsedAmountPlant1, onUsedAmountPlant2 = {}, usedHealthAmountPlant2 =onUsedAmountPlant2 , totalHealthAmountPlant2 =onTotalAmountPlant2, resourceTotalAmount =onTotalResourceAmount , resourceAmount = onResourceAmount, onresourceAmount = {
                    onResourceAmount+=it
                }, listOfCard = cardList)
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