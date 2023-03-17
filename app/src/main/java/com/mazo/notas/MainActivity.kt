package com.mazo.notas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var nombre: EditText? = null
    var Nt1:EditText?= null
    var Nt2:EditText? = null
    var Nt3:EditText?= null

    var mensaje = "";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nombre=findViewById(R.id.Nombre)
        Nt1= findViewById(R.id.Nota1)
        Nt2= findViewById(R.id.Nota2)
        Nt3=findViewById(R.id.Nota3)


        val botom: Button = findViewById(R.id.BtnCalcular)
        botom.setOnClickListener {logica()}


    }

    private fun logica() {
        var promedio = (Nt1?.getText().toString().toFloat() + Nt2?.getText().toString().toFloat() + Nt3?.getText().toString().toFloat()) / 3

        if (promedio >= 3.5){
            mensaje = "Aprobo la materia exitosamente"
        } else {
            mensaje = "Reprobo la meteria, seurte en la proxima"
        }


        if(promedio != null) {
            newView(promedio)
        }
    }

    private fun newView(float: Float) {
        val view = Intent(this, Menssagues::class.java)
        val myBlunde: Bundle = Bundle()
        myBlunde.putString("promedio", float?.toString())
        myBlunde.putString("not1", Nt1?.getText().toString())
        myBlunde.putString("not2", Nt2?.getText().toString())
        myBlunde.putString("not3", Nt3?.getText().toString())
        myBlunde.putString("nom", nombre?.getText().toString())
        myBlunde.putString("respu", mensaje)
        view.putExtras(myBlunde)
        startActivity(view)

    }
}
