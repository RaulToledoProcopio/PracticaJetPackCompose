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
    val navController = rememberNavController() // Creamos un NavHost que se encarga de gestionar la navegación entre pantallas
    NavHost(navController = navController, startDestination = AppScreen.MainScreen.route) { // Definimos el NavHost que maneja la navegación entre pantallas
        composable(AppScreen.MainScreen.route) { // Configuramos la ruta para la pantalla principal.
            MainScreen(navController = navController)
        }
        composable( // Configuramos la ruta para la pantalla secundaria y los argumentos que le pasaremos.
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
