package zone.nora.basicallylouis.gson.mojang

import com.google.gson.annotations.SerializedName

class SerializedAshconUser {
    @SerializedName("uuid")
    val uuid: String = "null"

    @SerializedName("username")
    val username: String = "null"

    @SerializedName("username_history")
    val usernameHistory: ArrayList<Username> = ArrayList()

    @SerializedName("textures")
    val textures: Textures = Textures()

    class Username {
        @SerializedName("username")
        val username: String = ""
    }

    class Textures {
        @SerializedName("skin")
        val skin: Skin = Skin()

        class Skin {
            @SerializedName("url")
            val url: String = "http://assets.mojang.com/SkinTemplates/steve.png"
        }
    }
}