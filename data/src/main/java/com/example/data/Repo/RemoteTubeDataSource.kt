package com.example.data.Repo

import com.example.domain.entity.Tube
import kotlinx.coroutines.flow.Flow

//interface RemoteTubeDataSource {
//
//}
interface RemoteTubeDataSource {

    fun getStatus(): Flow<List<Tube?>?>

    fun getStatusItem(id: Int?): Flow<Tube>
}