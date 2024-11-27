package com.example.jetpackcompose.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.jetpackcompose.Navigation.AppScreen

@Composable
fun SecondScreen(
    navController: NavHostController, // Recibimos el controlador de navegación para manejar las rutas
    text1: String?, // Parametro que va a recibir el nombre
    text2: String?, // Apellido
    text3: String?, // Ciudad
    text4: String? // DNI
) {

    /* Contenido principal de la página en el que simplemente se muestra un aviso de que se ha generado correctamente
    y luego los parámetros que hemos recibido en cada campo */

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Confirmación
            Text(
                text = "Su usuario ha sido creado",
                fontSize = 24.sp,
                color = Color(0xFF058605)
            )
            Spacer(modifier = Modifier.height(25.dp))

            // Nombre
            Text(text = "Nombre: $text1", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))

            // Apellidos
            Text(text = "Apellidos: $text2", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))

            // Ciudad
            Text(text = "Ciudad: $text3", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))

            // DNI
            Text(text = "DNI: $text4", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(25.dp))

            // Botón para volver
            Button(
                onClick = {
                    navController.navigate(AppScreen.MainScreen.route)
                }
            ) {
                Text("Volver")
            }
        }
    }
}