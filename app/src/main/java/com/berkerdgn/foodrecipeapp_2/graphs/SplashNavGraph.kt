package com.berkerdgn.foodrecipeapp_2.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.berkerdgn.foodrecipeapp_2.LogoScreen
import com.berkerdgn.foodrecipeapp_2.OnBoardingScreen

fun NavGraphBuilder.splashNavGraph(navController: NavHostController){
    navigation(
        route = Graph.SPLASHSCREEN,
        startDestination = SplashScreen.Logo.route
    ){
        composable(route = SplashScreen.Logo.route){
            LogoScreen(navController = navController)
        }
        composable(route = SplashScreen.OnBoarding.route){
            OnBoardingScreen(navController = navController)
        }

    }
}

sealed class SplashScreen(val route: String){
    object Logo : SplashScreen(route = "LOGO")
    object OnBoarding : SplashScreen(route = "ONBOARDING")
}