package com.berkerdgn.foodrecipeapp_2.presentation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.berkerdgn.foodrecipeapp_2.presentation.BottomBarScreen
import com.berkerdgn.foodrecipeapp_2.presentation.FoodListScreen
import com.berkerdgn.foodrecipeapp_2.presentation.SaveFoodScreen

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomBarScreen.Home.route
    ){
        composable(route = BottomBarScreen.Home.route){
            FoodListScreen()
        }
        composable(route = BottomBarScreen.Save.route){
            SaveFoodScreen()
        }

        detailsNavGraph(navController)

    }
}

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController){
    navigation(
        route = Graph.DETAILS,
        startDestination = DetailsScreen.Recipe.route
    ){
        composable(route = DetailsScreen.Recipe.route){
            //detay ekranı
        }
    }
}

sealed class DetailsScreen(val route: String){
    object Recipe: DetailsScreen(route = "RECIPE")
}