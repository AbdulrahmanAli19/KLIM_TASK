package abdulrahman.ali19.klim.data.repo

import abdulrahman.ali19.klim.data.pojo.DinosaurResponse
import abdulrahman.ali19.klim.data.remote.api.Api
import javax.inject.Inject

class HomeRepoImpl @Inject constructor(
    private val api: Api
) : HomeRepo {

    override suspend fun getDinosaur(): List<DinosaurResponse> {
        TODO("Not yet implemented")
    }
}