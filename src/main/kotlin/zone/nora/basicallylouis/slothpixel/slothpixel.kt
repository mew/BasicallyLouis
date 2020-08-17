package zone.nora.basicallylouis.slothpixel

import zone.nora.basicallylouis.config.SLOTHPIXEL_KEY
import zone.nora.basicallylouis.config.SLOTHPIXEL_URL
import zone.nora.slothpixel.Slothpixel
import zone.nora.slothpixel.player.Player
import java.lang.Exception
import kotlin.concurrent.thread

val slothpixel: Slothpixel = Slothpixel(url = SLOTHPIXEL_URL, apiKey = SLOTHPIXEL_KEY)
val playerCache: HashMap<String, Player?> = HashMap()

fun getPlayer(nameOrUuid: String): Player? {
    val name = nameOrUuid.toLowerCase()
    return try {
        if (playerCache.containsKey(name)) playerCache[name] else {
            val player = slothpixel.getPlayer(name)
            thread {
                playerCache[name] = player
                Thread.sleep(300000)
                playerCache.remove(name)
            }
            player
        }
    } catch (_: Exception) {
        playerCache[name] = null
        null
    }
}