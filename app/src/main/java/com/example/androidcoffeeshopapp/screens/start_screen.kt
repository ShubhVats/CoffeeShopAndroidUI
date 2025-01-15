package com.example.androidcoffeeshopapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.androidcoffeeshopapp.components.LogoComponent
import com.example.androidcoffeeshopapp.navigation.home
import kotlinx.coroutines.delay

@Composable
fun StartScreen(navhostController: NavHostController) {

    LaunchedEffect(key1 = Unit) {
        delay(2000)
        navhostController.navigate(home)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White), contentAlignment = Alignment.Center
    ) {
        LogoComponent()
    }
}