package abdulrahman.ali19.klim.data.remote.requst

import abdulrahman.ali19.klim.BuildConfig
import abdulrahman.ali19.klim.data.remote.api.Endpoints
import abdulrahman.ali19.klim.basic.BaseRequestFactory

class HomeRequest : BaseRequestFactory() {

    override fun getEndPoint(): String = BuildConfig.BASE_URL + Endpoints.DINOSAURS

}