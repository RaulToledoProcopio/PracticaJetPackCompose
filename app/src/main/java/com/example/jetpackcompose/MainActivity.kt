package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcompose.Navigation.AppNavigation
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // Crear el navController en el Composable
                val navController = rememberNavController()
                AppNavigation(navController = navController)
            }
        }
    }
}
@Composable
@Preview(showBackground = true)
fun GreetingPreview() {
    JetpackComposeTheme {
        val navController = rememberNavController()
        AppNavigation(navController = navController)
    }
}
