fun main() {

    val japan = DevelopedCountry(
        "Japan",
        Continent.ASIA,
        details = CountryDetails(125, 4000.0),
        true
    )

    val india = Developingcountry(
        "India",
        Continent.ASIA,
        CountryDetails(1400, 2200.0),
        true
    )

    println(japan.getDescription())
    println()
    println(india.getDescription())

}

enum class Continent {
    ASIA, EUROPE, AFRICA, NORTH_AMERICA, SOUTH_AMERICA, OCEANIA, ANTARCTICA
}

data class CountryDetails(
    val populationMillions: Int,
    val gdpPerCapitalUSD: Double
)

// Base class
abstract class Country(
    val name: String,
    val continent: Continent,
    val details: CountryDetails
) {
    abstract fun getDescription(): String
}

// subclass 1
class DevelopedCountry(
    name: String,
    continent: Continent,
    details: CountryDetails,
    val isG7Member: Boolean
) : Country(name, continent, details) {
    override fun getDescription(): String {
        val g7Status = if (isG7Member) "a G7 member" else "not a G7 memeber"
        return "$name is a developed country in ${continent.name}. It has a population of " +
                "${details.populationMillions}M and GDP per capita of $${details.gdpPerCapitalUSD}. It is $g7Status."
    }
}

// subclass 2
class Developingcountry(
    name: String,
    continent: Continent,
    details: CountryDetails,
    val emergingMarket: Boolean
) : Country(name, continent, details) {

    override fun getDescription(): String {
        val marketType = if (emergingMarket) "an emerging market" else "a developing economy"
        return "$name is a developing country in ${continent.name}. It has a population of " +
                "${details.populationMillions}M and GDP per capita of $${details.gdpPerCapitalUSD}. It is $marketType"
    }
}











