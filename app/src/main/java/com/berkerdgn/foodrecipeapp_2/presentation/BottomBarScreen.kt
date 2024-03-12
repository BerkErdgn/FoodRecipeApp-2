package com.berkerdgn.foodrecipeapp_2.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector,
    val unselectedIcon: ImageVector
){
    object Home : BottomBarScreen(
        route = "HOME",
        title = "Home",
        icon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home
    )

    object Save : BottomBarScreen(
        route = "SAVE",
        title = "Save",
        icon = Icons.Filled.Favorite,
        unselectedIcon = Icons.Outlined.Favorite
    )

}