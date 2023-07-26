package com.example.platzifakeapi130tr.views.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.platzifakeapi130tr.models.register.RequestRegister
import com.example.platzifakeapi130tr.models.register.ResponseRegister
import com.example.platzifakeapi130tr.repositories.AuthRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

//S19
@HiltViewModel
class RegisterViewModel @Inject constructor(private val repo: AuthRepo) : ViewModel() {


    private val _responseRegister = MutableLiveData<Response<ResponseRegister>>()
    val registerResponse: LiveData<Response<ResponseRegister>> = _responseRegister

    fun register(request: RequestRegister) {
        viewModelScope.launch {
            val data = repo.register(request)
            _responseRegister.postValue(data)
        }
    }

}