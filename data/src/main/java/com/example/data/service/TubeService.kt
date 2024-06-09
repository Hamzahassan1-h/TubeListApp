package com.example.data.service

import com.example.data.Remote.network.Tube.TubeItemModel
import retrofit2.http.GET

interface TubeService {
    @GET("Status")
    suspend fun getStatus(): List<TubeItemModel>

    @GET("Status/{id}")
    suspend fun getStatusItem(id: Int?) : TubeItemModel
}