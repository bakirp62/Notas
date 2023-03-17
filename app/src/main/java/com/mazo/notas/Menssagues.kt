package com.mazo.notas

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.graphics.red
import androidx.core.graphics.toColorInt

class Menssagues : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menssagues)

        var mensaje = findViewById<TextView>(R.id.imprimir)
        var notasView = findViewById<TextView>(R.id.notes)
        var mensajeView = findViewById<TextView>(R.id.mensaje)


        var blunde: Bundle? = this.intent.extras


        if (blunde != null) {
            var promedio = "${blunde.getInt("promedio")}"
            mensaje.text = "Hola ${blunde.getString("nom")}"
            notasView.text =
                "sus notas: ${blunde.getString("not1")} + ${blunde.getString("not2")} + ${
                    blunde.getString("not3")
                } = ${blunde.getString("promedio")}"

            if (promedio.toFloat() < 3.5){
                mensaje.setTextColor(android.graphics.Color.parseColor("#58FF33"))
                
            } else {
                mensaje.setTextColor(android.graphics.Color.parseColor("#EA0808"))
            }
            mensajeView.text = "${blunde.getString("respu")}"



        }


    }

}




