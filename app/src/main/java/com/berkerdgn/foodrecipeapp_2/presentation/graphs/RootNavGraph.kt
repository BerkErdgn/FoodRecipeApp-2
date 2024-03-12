package com.berkerdgn.foodrecipeapp_2.presentation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.berkerdgn.foodrecipeapp_2.presentation.HomeScreen

@Composable
fun RootNavigationGraph(navController: NavHostController ) {
    NavHost(navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.SPLASHSCREEN
    ){
        splashNavGraph(navController = navController)
        composable(route = Graph.HOME){
            HomeScreen()
        }
    }

}
object Graph{
    const val ROOT = "root_graph"
    const val SPLASHSCREEN = "splashscreen_graph"
    const val HOME = "home_graph"
    const val DETAILS = "details_graph"
}
