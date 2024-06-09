package com.example.data.Repo

import com.example.domain.entity.Tube
import com.example.domain.repo.TubeRepository
import kotlinx.coroutines.flow.Flow

//class TubeRepositoryImpl {
//}

class TubeRepositoryImpl(
    private val remoteSource: RemoteTubeDataSource
): TubeRepository {

    override fun getStatus(): Flow<List<Tube?>?> {
        return remoteSource.getStatus()
    }

    override fun getStatusItem(id: Int?): Flow<Tube> {
        return remoteSource.getStatusItem(id)
    }
}