package abdulrahman.ali19.klim.data.remote.requst

import abdulrahman.ali19.klim.basic.BaseRequestFactory
import abdulrahman.ali19.klim.data.remote.api.Endpoints

class HomeRequest : BaseRequestFactory() {

    override fun getEndPoint(): String = Endpoints.DINOSAURS

}