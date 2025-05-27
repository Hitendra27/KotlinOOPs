fun main() {

    val customer = Customer("John Doe", "john@example.com")

    val shoe1 = RunningShoe(ShoeBrand.NIKE, 42)
    val shoe2 = FormalShoe(ShoeBrand.CLARKS, 43)

    val condition: ShoeCondition = ShoeCondition.Refurbished("Minor scuff on left heel")

    println("Customer; ${customer.name}")
    println("Shoe !: ${shoe1.category()}, Brand: ${shoe1.brand}, Size: ${shoe1.size}")
    shoe1.tryOn()

    println()

    println("Shoe 2: ${shoe2.category()}, Brand: ${shoe2.brand}, Size: ${shoe2.size}")
    shoe2.tryOn()

    println()

    when (condition) {
        is ShoeCondition.New -> println("The shoe is brand new.")
        is ShoeCondition.Used -> println("The shoe is used.")
        is ShoeCondition.Refurbished -> println("Refurbished: ${condition.note}")
    }

    shoe1.returnItem()
    shoe2.returnItem()

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

class FormalShoe(
    brand: ShoeBrand,
    size: Int
) : Shoe(brand, size) {
    override fun category(): String = "Formal"

    override fun tryOn() {
        println("Trying on formal shoes of size $size from $brand")
    }

    override fun returnItem() {
        println("Returning formal shoes to store")
    }
}






















