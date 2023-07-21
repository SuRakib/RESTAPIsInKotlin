package com.example.platzifakeapi130tr.repositories

import com.example.platzifakeapi130tr.models.login.RequestLogin
import com.example.platzifakeapi130tr.models.login.ResponseLogin
import com.example.platzifakeapi130tr.services.AuthService
import retrofit2.Response
import javax.inject.Inject

//S8

class AuthRepo @Inject constructor(val service: AuthService) {

    suspend fun login(request:RequestLogin):Response<ResponseLogin>{

        return  service.login(request)


    }


}