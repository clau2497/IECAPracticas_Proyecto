package com.example.iecefirebase

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.iecefirebase.ui.theme.IECEFirebaseTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : ComponentActivity() {

  private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainactivitylayout)

        auth = FirebaseAuth.getInstance()
        loginAnonymous()
    }

    override fun onStart() {
        super.onStart()
        val currentUser: FirebaseUser? = auth.currentUser
        if (currentUser != null) {
            //el usuario ya esta autenticado
            Toast.makeText(  this,"Bienvenido" + currentUser.email, Toast.LENGTH_LONG).show()

        } else {
            login("claudiabarajas76@gmail.com","123456")

        }
    }

    fun login(email: String, password: String){
        // Iniciar sesión con correo electrónico y contraseña
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {task ->
                if (task.isSuccessful) {
                    // Inicio de sesión exitoso
                    val user = auth.currentUser
                    // Hacer algo con el usuario autenticado
                    Toast.makeText(  this,"Inicio de sesión exitoso", Toast.LENGTH_LONG).show()
                } else {
                    // Error en el inicio de sesión
                    Toast.makeText( this,"Error en el inicio de sesion: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                }}
    }

    fun loginAnonymous(){
        // Iniciar sesión con correo electrónico y contraseña
        auth.signInAnonymously()
            .addOnCompleteListener(this) {task ->
                if (task.isSuccessful) {
                    // Inicio anonimo de sesión exitoso
                    val user = auth.currentUser
                    // Hacer algo con el usuario autenticado
                    Toast.makeText(  this,"Inicio aninimo de sesión exitoso", Toast.LENGTH_LONG).show()
                } else {
                    // Error en el inicio de sesión
                    Toast.makeText( this,"Error en el inicio de sesion: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                }}
    }
}

