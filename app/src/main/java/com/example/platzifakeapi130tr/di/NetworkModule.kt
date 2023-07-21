package com.example.platzifakeapi130tr.di

import com.example.platzifakeapi130tr.services.AuthService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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



}