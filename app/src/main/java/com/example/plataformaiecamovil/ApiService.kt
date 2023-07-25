package com.example.plataformaiecamovil
import android.telecom.Call
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiService {
    @POST("/login")
    fun login(@Body loginRequest: LoginRequest): Call<LoginResponse>


}