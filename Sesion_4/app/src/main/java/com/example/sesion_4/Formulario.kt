package com.example.sesion_4

import android.annotation.SuppressLint
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText

class Formulario : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)
        val nombre = findViewById<EditText>(R.id.nombre)
        val email = findViewById<EditText>(R.id.email)
        val comentarios = findViewById<EditText>(R.id.comentarios)
        val boton = findViewById<Button>(R.id.boton)

        fun onCheckboxClicked(view: View) {
            if (view is CheckBox) {
                val checked: Boolean = view.isChecked

                when (view.id) {
                    R.id.checkbox_meat -> {
                        if (checked) {
                            // Put some meat on the sandwich
                        } else {
                            // Remove the meat
                        }
                    }
                    R.id.checkbox_cheese -> {
                        if (checked) {
                            // Cheese me
                        } else {
                            // I'm lactose intolerant
                        }
                    }
                    // TODO: Veggie sandwich
                }
            }
        }


    }
}