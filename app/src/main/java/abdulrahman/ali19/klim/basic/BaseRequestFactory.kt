package abdulrahman.ali19.klim.basic

import abdulrahman.ali19.klim.BuildConfig
import java.util.*
import kotlin.collections.HashMap


abstract class BaseRequestFactory {

    private var defaultHadres = HashMap<String, String>()

    init {
        defaultHadres["x-localization"] = Locale.getDefault().language
        defaultHadres["Accept"] = "application/json"
        defaultHadres["Connection"] = "close"
    }

    abstract fun getEndPoint(): String?

    open fun getUrl() = BuildConfig.BASE_URL + getEndPoint()

    open fun getCustomHeaders(): HashMap<String, String> = HashMap()

    fun getHeaderParam(): HashMap<String, String> {
        val headers = HashMap<String, String>()
        headers.putAll(defaultHadres)
        if (getCustomHeaders().isNotEmpty())
            headers.putAll(getCustomHeaders())
        return headers
    }

}