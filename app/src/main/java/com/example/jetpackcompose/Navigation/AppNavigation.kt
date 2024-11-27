package com.example.jetpackcompose.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcompose.Screens.MainScreen
import com.example.jetpackcompose.Screens.SecondScreen
import androidx.navigation.NavController

@Composable
fun AppNavigation(navController: NavController) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreen.MainScreen.route) {
        composable(AppScreen.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(
            AppScreen.SecondScreen.route,
            arguments = listOf(
                navArgument("text1") { type = NavType.StringType },
                navArgument("text2") { type = NavType.StringType },
                navArgument("text3") { type = NavType.StringType },
                navArgument("text4") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val text1 = backStackEntry.arguments?.getString("text1")
            val text2 = backStackEntry.arguments?.getString("text2")
            val text3 = backStackEntry.arguments?.getString("text3")
            val text4 = backStackEntry.arguments?.getString("text4")
            SecondScreen(navController = navController, text1 = text1, text2 = text2, text3 = text3, text4 = text4)
        }
    }
}
