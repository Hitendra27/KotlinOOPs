fun main() {

    val runningInfo = ShoeInfo("Rubber", "Red")
    val formalInfo = ShoeInfo("Leather", "Black")

    val myRunningShoes = RunningShoe("Nike", 42, runningInfo)
    val myFormalShoes = FormalShoe("Clarks", 43, formalInfo)

    val shoes: List<Shoe> = listOf(myRunningShoes, myFormalShoes)

    for (shoe in shoes) {
        println(shoe.getDetails())
        if (shoe is Wearable) {
            println(shoe.wear())
        }
        println()
    }
}

// Base class (abstract)
abstract class Shoe(
    val brand: String,
    val size: Int
) {
    abstract fun getDetails(): String
}

// Wearable Interface
interface Wearable {
    fun wear(): String
}

// data class to hold Shoe info
data class ShoeInfo(
    val material: String,
    val color: String
)

// Subclasses of Shoe
class RunningShoe(
    brand: String,
    size: Int,
    val info: ShoeInfo
) : Shoe(brand, size), Wearable {
    override fun getDetails(): String {
        return "Running Shoe - $brand, Size $size, Material: ${info.material}, Color: ${info.color}"
    }

    override fun wear(): String {
        return "Ready for a run with $brand shoes!"
    }
}

// Subclass of shoe 2
class FormalShoe(
    brand: String,
    size: Int,
    val info: ShoeInfo
) : Shoe(brand, size), Wearable {
    override fun getDetails(): String {
        return "Formal Shoe - $brand, Size $size, Made of ${info.material}, Color: ${info.color}"
    }

    override fun wear(): String {
        return "Looking sharp with $brand formal shoes!"
    }
}









