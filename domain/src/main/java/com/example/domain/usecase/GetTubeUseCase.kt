package com.example.domain.usecase

import com.example.domain.UseCase
import com.example.domain.entity.Tube
import com.example.domain.repo.TubeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

//class GetTubeUseCase {
//}

class GetTubeUseCase(
    configuration: Configuration,
    private val repo: TubeRepository
): UseCase<GetTubeUseCase.Request, GetTubeUseCase.Response>(configuration) {

    override fun process(request: Request): Flow<Response> =
        repo.getStatus()
            .map {
                Response(it)
            }
    data object Request : UseCase.Request
    data class Response(val status: List<Tube?>?) : UseCase.Response


}