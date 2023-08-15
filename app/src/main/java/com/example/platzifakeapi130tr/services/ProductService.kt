package com.example.platzifakeapi130tr.services

import com.example.platzifakeapi130tr.models.product.ResponseProduct
import com.example.platzifakeapi130tr.models.product.ResponseProductItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

//ss-33
interface ProductService {

    @GET("products")
    suspend fun getAllProducts(): Response<ResponseProduct>


    //ss-39
    @GET("products/{id}")
    suspend fun getProductById(
        @Path("id") id: Int
    ): Response<ResponseProductItem>


}