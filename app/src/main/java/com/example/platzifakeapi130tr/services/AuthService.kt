package com.example.platzifakeapi130tr.services

import com.example.platzifakeapi130tr.models.login.RequestLogin
import com.example.platzifakeapi130tr.models.login.ResponseLogin
import com.example.platzifakeapi130tr.models.register.RequestRegister
import com.example.platzifakeapi130tr.models.register.ResponseRegister
import retrofit2.Response
import retrofit2.http.POST


//s5
interface AuthService {

    @POST("auth/login")
    suspend fun login(request: RequestLogin): Response<ResponseLogin>


    //s17
    @POST("users")
    suspend fun register(request: RequestRegister): Response<ResponseRegister>

}