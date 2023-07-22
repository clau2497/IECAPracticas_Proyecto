package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import okhttp3.Call
import okhttp3.Response
import javax.security.auth.callback.Callback

class Login : AppCompatActivity() {

    lateinit var btnLogin : Button
    lateinit var etEmail: EditText
    lateinit var etPassword : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin= findViewById(R.id.idBtnLogin)
        etEmail= findViewById(R.id.idEdtUserName)
        etPassword= findViewById(R.id.idEdtPassword)

        btnLogin.setOnClickListener{
            val apiService = ApiClient.getClient()

            val body : LoginRequest = LoginRequest(etEmail.text.toString(), etPassword.text.toString())

            val call = apiService.login(body)
            call.enqueue(object : Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response : Response<LoginResponse>
                ){
                    if(response.isSuccessful){
                        val loginResponse = response.body()
                        tvHeader.text = "Bienvenido" + loginResponse?.name
                        Toast.makeText(applicationContext, "Todo ok" , Toast.LENGTH_LONG).show()
                    }else {
                        Toast.makeText(applicationContext, "Error ok" , Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<LoginResponse> , t: Throwable){
                    Toast.makeText(applicationContext, "Error de red" , Toast.LENGTH_LONG).show()

                }
            })
        }


    }
}