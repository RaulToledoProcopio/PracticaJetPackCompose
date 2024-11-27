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
import androidx.compose.ui.graphics.Color


@Composable
fun MainScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
    // Declaramos los estados para los campos de texto
) {
    var inputText1 by remember { mutableStateOf("") }
    var inputText2 by remember { mutableStateOf("") }
    var inputText3 by remember { mutableStateOf("") }
    var inputText4 by remember { mutableStateOf("") }

    // Declaramos los estados para los mensajes de error.
    var errorMessage1 by remember { mutableStateOf("") }
    var errorMessage2 by remember { mutableStateOf("") }
    var errorMessage3 by remember { mutableStateOf("") }
    var errorMessage4 by remember { mutableStateOf("") }

    // Nos aseguramos de poder volver a rellenar el formulario en caso de error.
    var valid by remember { mutableStateOf(true) }


    /*Contenido principal de la página con el formato correspondiente y gestión de los mensajes de error en
    caso de que el campo este vacío*/
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // Nombre Field
        TextField(
            value = inputText1,
            onValueChange = { inputText1 = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth(),
            isError = errorMessage1.isNotEmpty()
        )
        if (errorMessage1.isNotEmpty()) {
            Text(text = errorMessage1, color = Color.Red)
        }

        Spacer(modifier = Modifier.height(8.dp)) // Espaciado entre los campos

        // Apellidos Field
        TextField(
            value = inputText2,
            onValueChange = { inputText2 = it },
            label = { Text("Apellidos") },
            modifier = Modifier.fillMaxWidth(),
            isError = errorMessage2.isNotEmpty()
        )
        if (errorMessage2.isNotEmpty()) {
            Text(text = errorMessage2, color = Color.Red)
        }

        Spacer(modifier = Modifier.height(8.dp)) // Espaciado entre los campos

        // Ciudad Field
        TextField(
            value = inputText3,
            onValueChange = { inputText3 = it },
            label = { Text("Ciudad") },
            modifier = Modifier.fillMaxWidth(),
            isError = errorMessage3.isNotEmpty()
        )
        if (errorMessage3.isNotEmpty()) {
            Text(text = errorMessage3, color = Color.Red)
        }

        Spacer(modifier = Modifier.height(8.dp)) // Espaciado entre los campos

        // DNI Field
        TextField(
            value = inputText4,
            onValueChange = { inputText4 = it },
            label = { Text("DNI") },
            modifier = Modifier.fillMaxWidth(),
            isError = errorMessage4.isNotEmpty()
        )
        if (errorMessage4.isNotEmpty()) {
            Text(text = errorMessage4, color = Color.Red)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Enviar Button
        Button(
            onClick = {
                // Al hacer clic, reseteamos valid a true para validar nuevamente
                valid = true

                // Validar nombre
                if (inputText1.isEmpty()) {
                    errorMessage1 = "Este cuadro no puede estar vacío"
                    valid = false
                } else {
                    errorMessage1 = ""
                }

                // Validar apellidos
                if (inputText2.isEmpty()) {
                    errorMessage2 = "Este cuadro no puede estar vacío"
                    valid = false
                } else {
                    errorMessage2 = ""
                }

                // Validar ciudad
                if (inputText3.isEmpty()) {
                    errorMessage3 = "Este cuadro no puede estar vacío"
                    valid = false
                } else {
                    errorMessage3 = ""
                }

                // Validar DNI
                if (inputText4.isEmpty()) {
                    errorMessage4 = "Este cuadro no puede estar vacío"
                    valid = false

                /* Con Regex nos aseguramos de que los datos que se pasan estén entre el 0 y el 9
                y entre la A y la Z, en este caso mayúsculas al ser un DNI*/

                } else if (!Regex("^[0-9]{8}[A-Za-z]{1}$").matches(inputText4)) {
                    errorMessage4 = "El formato no es válido"
                    valid = false
                } else {
                    errorMessage4 = ""
                }

                // Solo navegamos si es válido
                if (valid) {
                    val route = AppScreen.SecondScreen.createRoute(inputText1, inputText2, inputText3, inputText4)
                    navController.navigate(route)
                }
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