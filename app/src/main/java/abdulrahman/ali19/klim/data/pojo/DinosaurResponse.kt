package abdulrahman.ali19.klim.data.pojo

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DinosaurResponse(

    @field:SerializedName("Name")
    val name: String? = null,
    @field:SerializedName("Description")
    val description: String? = null

) : Serializable