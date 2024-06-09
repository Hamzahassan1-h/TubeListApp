package com.example.domain.repo

import com.example.domain.entity.Tube
import kotlinx.coroutines.flow.Flow


interface TubeRepository {
    fun getStatus(): Flow<List<Tube?>?>

    fun getStatusItem(id: Int?): Flow<Tube>
}