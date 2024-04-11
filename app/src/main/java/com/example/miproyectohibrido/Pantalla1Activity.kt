package com.example.miproyectohibrido

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.miproyectohibrido.ui.theme.MiProyectoHibridoTheme

class Pantalla1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pantalla1()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun Pantalla1() {
    val contexto = LocalContext.current
    val estadoInicial = ""
    var sueldo by remember {mutableStateOf( estadoInicial )}
    val sueldoLiquido:Double=0.87
    var resultado by remember {mutableStateOf( estadoInicial )}

    Column(
        modifier = Modifier.fillMaxSize().background(Color.Cyan)
    ){
        Button(onClick = {
            val intent = Intent(contexto, MainActivity::class.java)
            contexto.startActivity(intent)
        }) {
            Text(text = "<- Volver")
        }
        Text(text = "Calcular Sueldo de Empleado a Honorarios")
        TextField(
            value = sueldo,
            onValueChange = { sueldo = it },
            label = { Text(text = "Sueldo") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
        Button(onClick = {
            val sueldoNumero = sueldo.toIntOrNull() ?:0
            val total = calcularSueldo(sueldoNumero, sueldoLiquido)
            resultado = "El sueldo a percibir es: $ $total"
        }) {
            Text(text ="Calcular el sueldo")
        }
        Text(text = resultado)
    }
    }
fun calcularSueldo(sueldoNumero:Int, sueldoLiquido: Double): Double {
    return sueldoNumero * sueldoLiquido
}