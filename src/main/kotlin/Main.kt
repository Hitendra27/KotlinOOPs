fun main() {

}

// Enum class
enum class PerfumeType {
    FLORAL,
    WOODY,
    FRESH,
    ORIENTAL,
    CITRUS
}

data class PerfumeDetails(
    val brand: String,
    val volumeInML: Int,
    val price: Double
)

// Base class
abstract class Perfume(
    val name: String,
    val type: PerfumeType,
    val details: PerfumeDetails
) {
    abstract fun describe(): String
}

// subclass 1
class DesignerPerfume(
    name: String,
    type: PerfumeType,
    details: PerfumeDetails,
    val celebrityEndorsed: Boolean
) : Perfume(name, type, details) {

    override fun describe(): String {
        val celebNote = if (celebrityEndorsed) "endorsed by a celebrity" else "not celebrity-endorsed"
        return "$name is ${type.name.lowercase()} designer perfume, " +
                "$celebNote, by ${details.brand}," +
                "It costs $${details.price} for ${details.volumeInML}ml."
    }
}

class NichePerfume(
    name: String,
    type: PerfumeType,
    details: PerfumeDetails,
    val limitedEdition: Boolean
) : Perfume(name, type, details) {

    override fun describe(): String {
        val editionNote = if (limitedEdition) "a limited edition release" else "part of the regular collection"
        return "$name is a ${type.name.lowercase()} niche perfume, $editionNote, from ${details.brand}." +
                "It costs $${details.price} for ${details.volumeInML}ml."
    }
}











