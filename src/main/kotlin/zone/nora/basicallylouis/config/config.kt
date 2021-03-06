package zone.nora.basicallylouis.config

/**
 * Discord Bot Token.
 */
const val BOT_TOKEN: String = "bot-token"

/**
 * Your Discord ID.
 */
const val OWNER_ID: Long = 161992742686162944L

/**
 * Your bot's command prefix.
 */
const val COMMAND_PREFIX: String = "-"

/**
 * Your server's #bot-commands channel.
 */
const val BOT_COMMANDS_CHANNEL: Long = 616059002849329152L

/**
 * Embed footer put at the bottom of all embeds.
 */
const val EMBED_FOOTER: String = "(c) Nora 2020"

/**
 * Image used in the bot's help message
 */
const val BOT_IMAGE: String = "https://i.gyazo.com/e2e5cf9460cacfbaa2c074647e1efb10.png"

/**
 * Image shown on a command failing.
 */
const val ERROR_IMAGE: String = "https://upload.wikimedia.org/wikipedia/commons/thumb/2/24/Warning_icon.svg/865px-Warning_icon.svg.png"

/**
 * Discord IDs of users who are blocked from using the bot.
 */
val BLOCKED_USERS: List<Long> = listOf(
    711562322878922803L
)

/**
 * Your Slothpixel url. If you are not self-hosting Slothpixel, leave this as is.
 */
const val SLOTHPIXEL_URL: String = "https://api.slothpixel.me/api"

/**
 * Your Slothpixel API Key. If you do not have one, leave this as null.
 */
val SLOTHPIXEL_KEY: String? = null