package com.example.common.nav

import com.google.gson.Gson


data class TubeListInput (
    val created: String?,
    val id: String?,
    val modeName: String?,
    val modified: String?,
    val name: String?


){
    fun toJson(): String {
        return Gson().toJson(this)
    }

    companion object {
        fun fromJson(json: String) : TubeListInput {
            return Gson().fromJson(json, TubeListInput::class.java)
        }
    }
}




