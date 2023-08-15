package com.example.platzifakeapi130tr.services

import com.example.platzifakeapi130tr.models.login.RequestLogin
import com.example.platzifakeapi130tr.models.login.ResponseLogin
import com.example.platzifakeapi130tr.models.register.RequestRegister
import com.example.platzifakeapi130tr.models.register.ResponseRegister
import com.example.platzifakeapi130tr.models.user.ResponseUser
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST


//s25-2
interface UserService {

    @GET("auth/profile")
    suspend fun getUserProfile(): Response<ResponseUser>



}