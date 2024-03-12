package com.berkerdgn.foodrecipeapp_2.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.berkerdgn.foodrecipeapp_2.presentation.graphs.RootNavigationGraph
import com.berkerdgn.foodrecipeapp_2.presentation.theme.ui.FoodRecipeApp2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodRecipeApp2Theme {
                // A surface container using the 'background' color from the theme
                RootNavigationGraph(navController = rememberNavController())
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FoodRecipeApp2Theme {

    }
}