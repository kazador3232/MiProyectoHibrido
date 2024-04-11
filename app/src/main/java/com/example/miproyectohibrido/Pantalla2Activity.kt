package com.example.miproyectohibrido

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Pantalla2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla2)

        val btnVolver = findViewById<Button>(R.id.btnVolver)
        btnVolver.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val etSueldo = findViewById<EditText>(R.id.editTextSueldo)
        val sueldoLiquido:Double = 0.8
        val btn = findViewById<Button>(R.id.btnCalcular)
        val tvResultado = findViewById<TextView>(R.id.textViewResultado)
        btn.setOnClickListener {
            val sueldo = etSueldo.text.toString().toIntOrNull() ?: 0
            val total = calcularAreaRectangulo(sueldo, sueldoLiquido)
            tvResultado.text = "El sueldo a percibir es: $ ${total}"
        }
    }
}
fun calcularAreaRectangulo(sueldo:Int, sueldoLiquido:Double): Double {
    return sueldo * sueldoLiquido
}