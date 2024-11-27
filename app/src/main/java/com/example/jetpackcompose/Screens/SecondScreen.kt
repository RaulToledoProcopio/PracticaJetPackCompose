package com.example.jetpackcompose.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.jetpackcompose.Navigation.AppScreen

@Composable
fun SecondScreen(
    navController: NavHostController,
    text1: String?,
    text2: String?,
    text3: String?,
    text4: String?
) {
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
            Text(text = "Su usuario ha sido creado", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))

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
            Spacer(modifier = Modifier.height(8.dp))

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

