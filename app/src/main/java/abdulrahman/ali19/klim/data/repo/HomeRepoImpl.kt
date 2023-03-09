package abdulrahman.ali19.klim.data.repo

import abdulrahman.ali19.klim.data.pojo.DinosaurResponse
import abdulrahman.ali19.klim.data.remote.api.Api
import abdulrahman.ali19.klim.data.remote.requst.HomeRequest
import retrofit2.Response
import javax.inject.Inject

class HomeRepoImpl @Inject constructor(
    private val api: Api
) : HomeRepo {

    override suspend fun getDinosaur(request: HomeRequest): Response<List<DinosaurResponse>> {
        return api.getDinosaurs(
            url = request.getUrl(),
            headers = request.getCustomHeaders()
        )
    }
}