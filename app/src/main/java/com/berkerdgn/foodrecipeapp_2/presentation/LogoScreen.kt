package com.berkerdgn.foodrecipeapp_2.presentation

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.berkerdgn.foodrecipeapp_2.R
import com.berkerdgn.foodrecipeapp_2.presentation.graphs.SplashScreen
import com.berkerdgn.foodrecipeapp_2.presentation.theme.ui.customOrange
import kotlinx.coroutines.delay

@Composable
fun LogoScreen(navController: NavHostController) {

    //for Text
    val alpha = remember{
        Animatable(0f)
    }

    LaunchedEffect(key1 = true){

        //for Text
        alpha.animateTo(1f,
                animationSpec = tween(2500)
            )

        delay(1800)
        navController.popBackStack()
        navController.navigate(SplashScreen.OnBoarding.route)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isSystemInDarkTheme()) Color.DarkGray else Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LoaderAnimation(
            modifier = Modifier.size(350.dp),
            anim = R.raw.chef_animation
        )
        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = "Food Racipe",
            modifier = Modifier
                .alpha(alpha.value),
            fontSize = 25.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            color = customOrange
        )

    }




}

@Composable
fun LoaderAnimation (modifier: Modifier, anim: Int) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(anim))

    LottieAnimation(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        modifier = modifier
        )

}