package com.example.platzifakeapi130tr.models.user


import com.google.gson.annotations.SerializedName

//S25-1
data class ResponseUser(
    @SerializedName("avatar")
    var avatar: String?,
    @SerializedName("creationAt")
    var creationAt: String?,
    @SerializedName("email")
    var email: String?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("password")
    var password: String?,
    @SerializedName("role")
    var role: String?,
    @SerializedName("updatedAt")
    var updatedAt: String?
)