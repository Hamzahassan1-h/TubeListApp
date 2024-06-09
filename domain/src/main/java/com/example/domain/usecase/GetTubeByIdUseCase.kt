package com.example.domain.usecase



import com.example.domain.UseCase
import com.example.domain.entity.Tube
import com.example.domain.repo.TubeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

//class GetTubeByIdUseCase {
//}

class GetTubeByIdUseCase (
    configuration: Configuration,
    private val repo: TubeRepository
) : UseCase<GetTubeByIdUseCase.Request, GetTubeByIdUseCase.Response>(configuration) {

    override fun process(request: Request): Flow<Response> =
        repo.getStatusItem(request.id)
            .map{
                Response(it)
            }

    data class Request(val id: Int?) : UseCase.Request
    data class Response(val statusItem: Tube?) : UseCase.Response
}