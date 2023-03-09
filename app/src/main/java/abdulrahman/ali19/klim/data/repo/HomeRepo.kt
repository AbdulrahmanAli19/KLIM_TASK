package abdulrahman.ali19.klim.data.repo

import abdulrahman.ali19.klim.data.pojo.DinosaurResponse
import abdulrahman.ali19.klim.data.remote.requst.HomeRequest
import retrofit2.Response

interface HomeRepo {
    suspend fun getDinosaur(request: HomeRequest): Response<List<DinosaurResponse>>

}