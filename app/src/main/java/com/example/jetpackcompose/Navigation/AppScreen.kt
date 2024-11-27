package com.example.jetpackcompose.Navigation

sealed class AppScreen(val route: String) {
    object MainScreen : AppScreen("main_screen")
    object SecondScreen : AppScreen("second_screen/{text1}/{text2}/{text3}/{text4}") {
        fun createRoute(text1: String, text2: String, text3: String, text4: String) =
            "second_screen/$text1/$text2/$text3/$text4"
    }
}
