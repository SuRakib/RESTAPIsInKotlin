package com.example.platzifakeapi130tr.services

import com.example.platzifakeapi130tr.models.login.RequestLogin
import com.example.platzifakeapi130tr.models.login.ResponseLogin
import retrofit2.Response
import retrofit2.http.POST


//s5
interface AuthService {

    @POST("auth/login")
    suspend fun login(request: RequestLogin): Response<ResponseLogin>

}