package com.example.platzifakeapi130tr.views.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.platzifakeapi130tr.models.user.ResponseUser
import com.example.platzifakeapi130tr.repositories.UserRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject
//S-27
@HiltViewModel
class ProfileViewModel @Inject constructor(private  val repo: UserRepo) : ViewModel(){


    private val _response = MutableLiveData<Response<ResponseUser>> ()

    val profileResponse: LiveData<Response<ResponseUser>> = _response

    fun getUserProfile() {

        viewModelScope.launch {

            val data=repo.getUserProfile()
            _response.postValue(data)



        }


    }

}