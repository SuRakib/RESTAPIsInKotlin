package com.example.platzifakeapi130tr.models.login


import com.google.gson.annotations.SerializedName

//s4
data class ResponseLogin(
    @SerializedName("access_token")
    var accessToken: String?,
    @SerializedName("refresh_token")
    var refreshToken: String?
)