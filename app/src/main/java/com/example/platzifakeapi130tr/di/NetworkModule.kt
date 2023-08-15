package com.example.platzifakeapi130tr.di

import com.example.platzifakeapi130tr.services.AuthService
import com.example.platzifakeapi130tr.services.ProductService
import com.example.platzifakeapi130tr.services.UserService
import com.example.platzifakeapi130tr.utils.AuthInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//S7

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun providesRetrofit() : Retrofit.Builder{

        return  Retrofit.Builder()
            .baseUrl("https://api.escuelajs.co/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())



    }

    fun providesAuthService(retrofit: Retrofit.Builder) : AuthService{

        return retrofit.build().create(AuthService::class.java)

    }

    //s-29

    @Provides
    @Singleton
    fun providesHttpClient(interceptor: AuthInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(interceptor).build()

    }

    @Provides
    @Singleton
    fun providesUserService(retrofit: Retrofit.Builder, client: OkHttpClient): UserService {
        return retrofit.client(client).build().create(UserService::class.java)

    }


    //ss38

    @Provides
    @Singleton
    fun providesProductService(retrofit: Retrofit.Builder): ProductService {
        return retrofit.build().create(ProductService::class.java)

    }





}