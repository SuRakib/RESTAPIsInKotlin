package com.example.platzifakeapi130tr.repositories
import com.example.platzifakeapi130tr.models.user.ResponseUser
import com.example.platzifakeapi130tr.services.UserService
import retrofit2.Response
import javax.inject.Inject

//s-26
class UserRepo @Inject constructor(val service: UserService) {

    suspend fun getUserProfile(): Response<ResponseUser> {

        return  service.getUserProfile()


    }

}