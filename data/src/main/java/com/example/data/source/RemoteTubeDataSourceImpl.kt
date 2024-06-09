package com.example.data.source

import com.example.data.Remote.network.Tube.TubeItemModel
import com.example.data.Repo.RemoteTubeDataSource
import com.example.data.service.TubeService
import com.example.domain.entity.Tube
import com.example.domain.entity.UseCaseException
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

//class RemoteTubeDataSourceImpl {
//}

class RemoteTubeDataSourceImpl @Inject constructor(
    private val service: TubeService
): RemoteTubeDataSource {
    override fun getStatus(): Flow<List<Tube?>?> = flow {
        val tube = service.getStatus()
        emit(tube)
    }.map { tubeList ->
        tubeList.map { tube -> convert(tube) }
    }.catch {
        throw UseCaseException.TubeException(it)
    }

    override fun getStatusItem(id: Int?): Flow<Tube> = flow {
        emit(service.getStatusItem(id))
    }.map {
        convert(it)
    }.catch {
        throw UseCaseException.TubeException(it)
    }

    private fun convert(model: TubeItemModel): Tube {
        return Tube(
            created = model.created,
            id = model.id,
            modeName = model.modeName,
            modified = model.modified,
            name = model.name

        )
    }


}