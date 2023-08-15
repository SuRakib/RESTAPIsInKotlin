package com.example.platzifakeapi130tr.views.product

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.platzifakeapi130tr.models.product.ResponseProduct
import com.example.platzifakeapi130tr.repositories.ProductRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

//ss-35
@HiltViewModel
class ProductViewModel @Inject constructor(private val repo: ProductRepo) : ViewModel() {

    private val _response = MutableLiveData<Response<ResponseProduct>>()
    val registerProduct: LiveData<Response<ResponseProduct>> = _response

    fun getAllProducts() {
        viewModelScope.launch {
            val data = repo.getAllProducts()
            _response.postValue(data)
        }
    }


}