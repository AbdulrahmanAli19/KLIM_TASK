package abdulrahman.ali19.klim.data.remote.api

import abdulrahman.ali19.klim.data.pojo.DinosaurResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Url

interface Api {

    @GET
    suspend fun getDinosaurs(
        @Url url: String,
        @HeaderMap headers: Map<String, String>
    ): Response<List<DinosaurResponse>>

}