fun main() {

}

interface Wearable {
    fun tryOn()
    fun returnItem()
}

enum class ShoeBrand {
    NIKE, ADIDAS, PUMA, CLARKS, GUCCI
}

abstract class Shoe(
    val brand: ShoeBrand,
    val size: Int
) : Wearable {
    abstract fun category(): String
}

data class Customer(
    val name: String,
    val email: String
)

sealed class ShoeCondition {
    object New: ShoeCondition()
    object Used: ShoeCondition()
    data class Refurbished(
        val note: String,
    ) : ShoeCondition()
}

class RunningShoe(
    brand: ShoeBrand,
    size: Int
) : Shoe(brand, size) {
    override fun category(): String = "Running"

    override fun tryOn() {
        println("Trying on running shoes of size $size from $brand")
    }

    override fun returnItem() {
        println("Returning running shoes to store")
    }
}






















