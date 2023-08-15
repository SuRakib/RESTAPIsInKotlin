package com.example.platzifakeapi130tr.repositories

import com.example.platzifakeapi130tr.models.product.ResponseProduct
import com.example.platzifakeapi130tr.models.product.ResponseProductItem
import com.example.platzifakeapi130tr.services.ProductService
import retrofit2.Response
import javax.inject.Inject


//ss 34
class ProductRepo @Inject constructor(private val service: ProductService) {

    suspend fun getAllProducts(): Response<ResponseProduct> {
        return service.getAllProducts()
    }

    //ss39

    suspend fun getProductById(id: Int): Response<ResponseProductItem> {

        return service.getProductById(id)

    }






}