package com.example.virtual_plant_pet.navigation.NavMaps

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.solus.navigation.navUtils.navScreens
import com.example.virtual_plant_pet.Presentation.screen.HomeScreen.HomeUtils.shopItems
import com.example.virtual_plant_pet.Presentation.screen.OnBoardingScreen.ChooseYourAvatarScreen
import com.example.virtual_plant_pet.Presentation.screen.OnBoardingScreen.FirstOnBoardingScreen
import com.example.virtual_plant_pet.Presentation.screen.OnBoardingScreen.SecondOnBoardinScreen
import com.example.virtual_plant_pet.Presentation.screen.OnBoardingScreen.YourNameScreen
import com.example.virtual_plant_pet.Presentation.screen.ViewModels.AuthViewModel
import com.example.virtual_plant_pet.R
import org.koin.androidx.compose.koinViewModel

@Composable
fun navScreen(navaHostController: NavHostController, viewModel: AuthViewModel = koinViewModel()) {
    var userName by remember {
        mutableStateOf("")
    }
    var avatarSelected by remember{
        mutableStateOf(0)
    }
    var usedLoadingAmountPlant by remember {
        mutableStateOf(0)
    }
    var LoadingAmountPlant by remember {
        mutableStateOf(300)
    }
    var visibility by remember {
        mutableStateOf(true)
    }
    var buttonVisibility by remember {
        mutableStateOf(false)
    }
    var buttonVisibilityNext by remember {
        mutableStateOf(true)
    }
    var counter by remember {
        mutableStateOf(0)
    }
    var empty by remember{
        mutableStateOf(false)
    }

    var emptyAvatar by remember{
        mutableStateOf(false)
    }
    var dismiss by remember {
        mutableStateOf(true)
    }
    var questDismiss by remember {
        mutableStateOf(false)
    }
    var isSelected by remember{
        mutableStateOf(false)
    }
    var isSelected1 by remember{
        mutableStateOf(false)
    }

    var isSelected2 by remember{
        mutableStateOf(false)
    }

    var isSelected3 by remember{
        mutableStateOf(false)
    }

    var isSelected4 by remember{
        mutableStateOf(false)
    }

    var isSelected5 by remember{
        mutableStateOf(false)
    }





    val videoTutorialIntro = listOf<String>(
        "Welcome, ${userName}",
        "Niwa is your garden",
        "Collect Plants from the wild",
        "Fight other plants to win resources",
        "If somebody Steals your plant, fight for it",
        "Care for your garden, and help your plants grow"
    )
    val videoTutorialIntro2 = listOf<String>(
        "Niwa",
        "Garden",
        "Wild",
        "Fight",
        "Steal",
        "Feed"
    )
    val shipList = listOf<shopItems>(
        shopItems(Image = R.drawable.thornyarmor, shopItem = "Thorny Armor"),
        shopItems(Image = R.drawable.bubbleburst, shopItem = "Bubble Burst"),
        shopItems(Image = R.drawable.petalstorm, shopItem = "Petal Storm"),
        )
    var shipItem by remember{
        mutableStateOf(0)
    }
    var plantList = listOf(
        R.drawable.p3,
        R.drawable.p2,
        R.drawable.p4,
        R.drawable.p5,
        R.drawable.p6,
        R.drawable.p7,
        R.drawable.p1,
        R.drawable.p8,
        R.drawable.p9,
        R.drawable.p10,
        R.drawable.p11,
        R.drawable.p12,
        R.drawable.p13,
        R.drawable.p14,
        R.drawable.p15,
        R.drawable.p16,
        R.drawable.p17,
        R.drawable.p18,
        R.drawable.p19,
        R.drawable.p20,
    )

    NavHost(
        navController = navaHostController,
        startDestination = navScreens.OnBoardingScreen.route
    ) {
        //AuthScreen Navigation
        authNavMap(navaHostController, viewModel)
        //BottomBar Navigation
        composable(navScreens.appNavScreen.route) {
            appNavMap(dismiss = dismiss, getDismiss = {
                dismiss = it
            }, getAppNavMap = {
                navaHostController.navigate(navScreens.appNavScreen.route){
                    popUpTo(navScreens.FightScreen.route){
                        inclusive=true
                    }
                }
            }, shopList = shipList, getShopList = {
                shipItem = it
            }, getQuestDismiss = {
                questDismiss = it
            }, onQuestDismiss = questDismiss)
        }



        composable(navScreens.OnBoardingScreen.route) {
            FirstOnBoardingScreen {
                navaHostController.navigate(navScreens.UserNameScreen.route) {
                    popUpTo(navScreens.OnBoardingScreen.route) {
                        inclusive = true
                    }
                }
            }
        }
        composable(navScreens.UserNameScreen.route) {

            YourNameScreen(onNavigate = {
                if (userName.isNotEmpty()){
                    navaHostController.navigate(navScreens.ChooseAvatarScreen.route) {
                        popUpTo(navScreens.UserNameScreen.route) {
                            inclusive = true
                        }
                    }
                    empty = false
                }else{
                    empty = true
                }


            }, userName = userName, getUserName = {
                userName = it
            }, empty = empty)
        }
        composable(navScreens.ChooseAvatarScreen.route){
            ChooseYourAvatarScreen(onNavigate = {
                                                if (avatarSelected!=0){
                                                    navaHostController.navigate(navScreens.OnBoardingScreen2.route) {
                                                        popUpTo(navScreens.ChooseAvatarScreen.route) {
                                                            inclusive = true
                                                        }
                                                    }
                                                    emptyAvatar = false
                                                }else{
                                                    emptyAvatar = true
                                                }
            }, getAvatar ={
                          avatarSelected = it
            } , empty = emptyAvatar, isSelected = isSelected, isSelected1 = isSelected1, isSelected2 = isSelected2, isSelected3 = isSelected3, isSelected4 = isSelected4, isSelected5 = isSelected5, getIsSelected = {
                isSelected = it
            }, getIsSelected1 = {
                isSelected1 = it
            }, getIsSelected2 = {
                isSelected2 = it
            }, getIsSelected3 = {
                isSelected3 = it
            }, getIsSelected4 = {
                isSelected4 = it
            }, getIsSelected5 = {
                isSelected5 = it
            })

        }
        composable(navScreens.OnBoardingScreen2.route) {

            SecondOnBoardinScreen(
                onNavigatie = {

                    navaHostController.navigate(navScreens.appNavScreen.route) {
                        popUpTo(navScreens.OnBoardingScreen2.route) {
                            inclusive = true
                        }
                    }

                },
                userName = userName,
                usedLoadingAmountPlant = usedLoadingAmountPlant,
                LoadingAmountPlant = LoadingAmountPlant,
                videoTutorialIntro = videoTutorialIntro,
                videoTutorialIntro2 = videoTutorialIntro2, getUsedLoadingPlant = {
                    if(usedLoadingAmountPlant>=LoadingAmountPlant){
                        buttonVisibility = true
                        buttonVisibilityNext = false

                    }else{
                        usedLoadingAmountPlant += it
                    }
                }, getbuttonVisibility = {
                    buttonVisibility = it
                }, buttonVisibility = buttonVisibility, getVisibility = {
                    visibility = it
                }, visibility = visibility, counter = counter, getCounter = {
                    Log.e("Counter",counter.toString())
                    Log.e("Counter",videoTutorialIntro2.size.toString())
                    if(counter>=videoTutorialIntro2.size-1){
                        buttonVisibility = true
                        buttonVisibilityNext = false
                    }else{
                        counter += it
                    }

                }, getbuttonVisibilityNext = {
                                             buttonVisibilityNext = it
                }, buttonVisibilityNext = buttonVisibilityNext
            )
        }


    }
}