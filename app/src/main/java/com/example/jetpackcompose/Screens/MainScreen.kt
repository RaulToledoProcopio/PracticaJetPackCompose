package com.example.jetpackcompose.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose.Navigation.AppScreen
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.compose.material3.Text


@Composable
fun MainScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    var inputText1 by remember { mutableStateOf("") }
    var inputText2 by remember { mutableStateOf("") }
    var inputText3 by remember { mutableStateOf("") }
    var inputText4 by remember { mutableStateOf("") }

    Column(
        modifier = modifier // Utilizamos el modifier aquí
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = inputText1,
            onValueChange = { inputText1 = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp)) // Espaciado entre los campos
        TextField(
            value = inputText2,
            onValueChange = { inputText2 = it },
            label = { Text("Apellidos") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp)) // Espaciado entre los campos
        TextField(
            value = inputText3,
            onValueChange = { inputText3 = it },
            label = { Text("Cuidad") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp)) // Espaciado entre los campos
        TextField(
            value = inputText4,
            onValueChange = { inputText4 = it },
            label = { Text("DNI") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val route = when {
                    inputText1.isNotEmpty() && inputText2.isNotEmpty() && inputText3.isNotEmpty() && inputText4.isNotEmpty() ->
                        AppScreen.SecondScreen.createRoute(inputText1, inputText2, inputText3, inputText4)
                    else -> AppScreen.SecondScreen.createRoute("No hay datos recibidos", "No hay datos recibidos", "No hay datos recibidos", "No hay datos recibidos")
                }
                navController.navigate(route)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Enviar")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MainScreenPreview() {
    JetpackComposeTheme {
        val navController = rememberNavController()
        MainScreen(navController = navController, modifier = Modifier.fillMaxSize())
    }
}