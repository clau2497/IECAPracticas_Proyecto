package com.example.sesion_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton

class Examen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_examen)

        fun onRadioButtonClicked(view: View) {
            if (view is RadioButton) {
                // Is the button now checked?
                val checked = view.isChecked

                // Check which radio button was clicked
                when (view.getId()) {
                    R.id.radio_pirates ->
                        if (checked) {
                            // Pirates are the best
                        }
                    R.id.radio_ninjas ->
                        if (checked) {
                            // Ninjas rule
                        }
                }
            }
        }
    }
}