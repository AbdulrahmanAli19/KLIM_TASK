package abdulrahman.ali19.klim.data.repo

import abdulrahman.ali19.klim.data.pojo.DinosaurResponse

interface HomeRepo {

    suspend fun getDinosaur(): List<DinosaurResponse>

}