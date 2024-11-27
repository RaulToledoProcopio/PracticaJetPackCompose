package com.example.jetpackcompose.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

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
            Text(text = text1 ?: "No hay datos recibidos 1", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = text2 ?: "No hay datos recibidos 2", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = text3 ?: "No hay datos recibidos 3", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = text4 ?: "No hay datos recibidos 4", fontSize = 18.sp)
        }
    }
}

