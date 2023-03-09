package abdulrahman.ali19.klim.domain.usecase

import abdulrahman.ali19.klim.basic.ResultState
import abdulrahman.ali19.klim.data.pojo.DinosaurResponse
import abdulrahman.ali19.klim.data.remote.requst.HomeRequest
import abdulrahman.ali19.klim.data.repo.HomeRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetDinosaurUseCase @Inject constructor(
    private val repo: HomeRepo
) {

    operator fun invoke(): Flow<ResultState<List<DinosaurResponse>>> = flow {
        emit(ResultState.Loading)

        val request = repo.getDinosaur(HomeRequest())

        if (request.isSuccessful)
            emit(ResultState.Success(request.body() ?: emptyList()))
        else if (request.errorBody() != null)
            emit(ResultState.Error(request.message()))
        else
            emit(ResultState.EmptyResult)
    }
}