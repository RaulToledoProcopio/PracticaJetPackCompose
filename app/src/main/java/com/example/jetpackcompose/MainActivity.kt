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
        super.onCreate(savedInstanceState) // Llamamos al metodo onCreate de la clase base.
        setContent { // Configuramos el contenido de la actividad usando Jetpack Compose.
            JetpackComposeTheme {
                val navController = rememberNavController() // Creamos el controlador de navegación que maneja la navegación entre pantallas.
                AppNavigation(navController = navController) // Llamamos a la función de navegación pasando el controlador de navegación como parámetro.
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
