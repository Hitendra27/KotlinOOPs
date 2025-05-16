fun main() {

    val california = USState(
        populationMillions = 39.24,
        isCoastal = true,
        name = "California",
        capital = "Sacramento",
        region = Region.WEST
    )

    val newYork = USState(
        populationMillions = 19.84,
        isCoastal = true,
        name = "New York",
        capital = "Albany",
        region = Region.NORTHEAST
    )

    println(california.description())
    println()
    println(newYork.description())

    val branches = listOf(
        FederalBranch.Execute,
        FederalBranch.Legislative,
        FederalBranch.Judicial
    )

    branches.forEach {
        println("${it::class.simpleName}: ${it.dutyDescription()}")
    }
}

enum class Region {
    NORTHEAST, MIDWEST, SOUTH, WEST
}

interface GovernmentDuty {
    fun dutyDescription(): String
}

abstract class State(
    val name: String,
    val capital: String,
    val region: Region
) {
    abstract fun description(): String
}

class USState(
    val populationMillions: Double,
    val isCoastal: Boolean,
     name: String,
     capital: String,
     region: Region
) : State(name, capital, region) {
    override fun description(): String {
        val coast = if (isCoastal) "on the coast" else "landlocked"
        return "$name is a state in the $region. Capital: $capital. Population: $populationMillions million. It is $coast."
    }
}

sealed class FederalBranch : GovernmentDuty {
    object Execute : FederalBranch() {
        override fun dutyDescription() = "Executes laws, headed by the President."
    }

    object Legislative : FederalBranch() {
        override fun dutyDescription() = "Makes laws, consists of Congress."
    }

    object Judicial : FederalBranch() {
        override fun dutyDescription() = "Interprets laws, headed by the Supreme Court."
    }
}














