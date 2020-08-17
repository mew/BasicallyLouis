package zone.nora.basicallylouis.commands.category

enum class Category(val asString: String, val id: Int) {
    GENERAL("General", 0),
    HYPIXEL("Hypixel", 1),
    FUN("Fun", 2),
    UTILITY("Utility", 3),
    MODERATION("Moderation", 4)
}