package zone.nora.basicallylouis.gson.server

import com.google.gson.annotations.SerializedName
import zone.nora.basicallylouis.config.ERROR_IMAGE

class SerializedMinecraftServer {
    @SerializedName("online")
    val online: Boolean = false

    @SerializedName("favicon")
    val favicon: String = ERROR_IMAGE

    @SerializedName("players")
    val players: Players = Players()

    fun getStatus(): String = if (online) "ONLINE" else "OFFLINE"

    class Players {
        @SerializedName("online")
        val online: Int = 0

        @SerializedName("max")
        val max: Int = 1
    }
}