package com.example.solus.navigation.navUtils

sealed class navScreens(val route:String){
    object authScreens:navScreens("authscreens_Solus")
    object appNavScreen:navScreens("appNavScreen_Solus")
    object bottomScreens:navScreens("bottomScreens_Solus")
    object HomeScreen:navScreens("HomeScreen_Solus")
    object FeedScreen:navScreens("FeedScreen_Solus")
    object ProfileScreen:navScreens("ProfileScreen_Solus")
    object LoginScreen: navScreens( "Login_Solus")
    object SignInScreen: navScreens( "SignIn_Solus")
    object StartInScreen: navScreens( "StartIn_Solus")
    object PetNameScreen: navScreens( "Pet_Solus")
    object UserNameScreen: navScreens( "User_Solus")
    object OnBoardingScreen: navScreens( "OnBoarding_Solus")
    object FightScreen: navScreens( "FightScreen_Solus")
    object StealScreen: navScreens( "StealScreen_Solus")
    object gameScreens: navScreens( "gameScreens_Solus")

}
