package com.example.sesion_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ActivityConFragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_con_fragment)

        val fragment = MiPrimerFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment, fragment)
            .commit()

    }
}