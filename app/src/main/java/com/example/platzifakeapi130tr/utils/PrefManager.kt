package com.example.platzifakeapi130tr.utils

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

//S19

class PrefManager  @Inject constructor( @ApplicationContext context: Context){

    private val pref=context.getSharedPreferences("pref",Context.MODE_PRIVATE)  //onno app don't read

    //dataset

    fun setPref(key: String, value: String){

        val prefEdit : SharedPreferences.Editor=pref.edit()

        prefEdit.putString(key, value)

        prefEdit.apply()

    }

    //dataget

    fun getPref(key: String) : String{

        return  pref.getString(key,"").toString()

    }


}