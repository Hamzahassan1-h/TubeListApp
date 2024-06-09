package com.example.data.Remote.network.Tube


import com.google.gson.annotations.SerializedName

data class TubeItemModel(
    @SerializedName("created")
    val created: String? = "",
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("modeName")
    val modeName: String? = "",
    @SerializedName("modified")
    val modified: String? = "",
    @SerializedName("name")
    val name: String? = "",

)