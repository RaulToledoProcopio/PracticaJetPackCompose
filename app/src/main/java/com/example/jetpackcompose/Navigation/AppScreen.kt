package com.example.jetpackcompose.Navigation

sealed class AppScreen(val route: String) {
    object MainScreen : AppScreen("main_screen") // Objeto para la pantalla principal
    object SecondScreen : AppScreen("second_screen/{text1}/{text2}/{text3}/{text4}") { // Objeto para la pantalla secundaria
        fun createRoute(text1: String, text2: String, text3: String, text4: String) = //Construimos la ruta de navegación
            "second_screen/$text1/$text2/$text3/$text4"
    }
}
