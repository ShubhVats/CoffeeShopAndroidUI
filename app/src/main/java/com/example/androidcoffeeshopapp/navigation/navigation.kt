package com.example.androidcoffeeshopapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidcoffeeshopapp.screens.HomeScreen
import com.example.androidcoffeeshopapp.screens.ProductDetailsScreen
import com.example.androidcoffeeshopapp.screens.StartScreen

@Composable
fun Navigation() {
    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = start) {
        composable(start) {
            StartScreen(navHostController)
        }
        composable(home) {
            HomeScreen(navHostController)
        }
        composable(product_details) {
            ProductDetailsScreen(navHostController)
        }
    }
}

const val start = "start_screen"
const val home = "home_screen"
const val product_details = "product_details_screen"
