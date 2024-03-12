package com.berkerdgn.foodrecipeapp_2.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.berkerdgn.foodrecipeapp_2.presentation.graphs.HomeNavGraph
import com.berkerdgn.foodrecipeapp_2.presentation.theme.ui.customOrange


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController = rememberNavController()) {

    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Save
    )
    var bottomNavState by rememberSaveable {
        mutableStateOf(0)
    }

    Scaffold (
        //bottomBar = { BottomBar(navController = navController) }
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .height(90.dp)
                    .padding(8.dp)
                    .clip(RoundedCornerShape(13.dp)),
                containerColor = customOrange
            ) {
                screens.forEachIndexed { index, item ->

                    NavigationBarItem(
                        selected = bottomNavState == index,
                        onClick = {
                                  bottomNavState = index
                                  navController.navigate(item.route){
                                      popUpTo(navController.graph.findStartDestination().id)
                                      launchSingleTop = true
                                  }
                        },
                        icon = {
                            Icon(
                                imageVector = if (bottomNavState == index) item.icon else item.unselectedIcon ,
                                contentDescription = item.title
                            )
                        },
                        label = {
                            Text(text = item.title)
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.Black,
                            selectedTextColor = Color.Black,
                            indicatorColor = Color(0xFFD86F00)
                        )
                    )
                }
            }
        }
    ){
        HomeNavGraph(navController = navController)
    }

}




/*
@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Save
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val bottomBarDestination = screens.any { it.route == currentDestination?.route }
    if (bottomBarDestination){
        BottomNavigation {
            screens.forEach { screen ->
                AddItem(
                        screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }

}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "Navigation Icon"
            )
        },
        selected = currentDestination?.hierarchy?.any{
            it.route == screen.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route){
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }

    )
}
 */