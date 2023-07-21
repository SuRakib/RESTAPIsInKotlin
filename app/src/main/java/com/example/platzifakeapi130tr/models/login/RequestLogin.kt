package com.example.platzifakeapi130tr.models.login


import com.google.gson.annotations.SerializedName
//s3
data class RequestLogin(
    @SerializedName("email")
    var email: String?,
    @SerializedName("password")
    var password: String?
)