package com.example.platzifakeapi130tr.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.platzifakeapi130tr.R
import dagger.hilt.android.AndroidEntryPoint

//ss14
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}