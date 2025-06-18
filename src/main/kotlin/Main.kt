
import java.util.*
fun main() {
}

interface Wearable {
    fun tryOn()
    fun purchase(customer: Customer)
    fun returnItem(customer: Customer)
}

enum class Size {
    XS, S, M, L, XL, XXL
}

enum class ClothingType {
    SHIRT, PANTS, JACKET, DRESS, SKIRT
}

abstract class Clothing(
    val name: String,
    val size: Size,
    val type: ClothingType,
    var price: Double,
    var stock: Int
) : Wearable {
    abstract fun description(): String

    fun applyDiscount(percent: Double) {
        price -= price * (percent / 100)
    }
}

data class Customer(
    val name: String,
    val membershipId: String,
    var rewardPoints: Int = 0,
    val purchaseHistory: MutableList<Clothing> = mutableListOf()
) {
    fun addPoints(points: Int) {
        rewardPoints += points
    }
}

sealed class ClothingStaus {
    object Available: ClothingStaus()
    object OutOfStock: ClothingStaus()
    data class Damaged(val reason: String): ClothingStaus()
}

class Shirt(
    name: String,
    size: Size,
    price: Double,
    stock: Int
) : Clothing(name, size, ClothingType.SHIRT, price, stock) {

    override fun tryOn() {
        println("Tying on shirt: $name (Size: $size)")
    }

    override fun purchase(customer: Customer) {
        if (stock > 0) {
            stock--
            customer.purchaseHistory.add(this)
            customer.addPoints(10)
            println("Shirt '$name' purchased. +10 reward points.")
        } else {
            println("Shirt '$name' is out of stock." )
        }
    }

    override fun returnItem(customer: Customer) {
        TODO("Not yet implemented")
    }

    override fun description(): String {
        return "$name is a stylish shirt in size $size."
    }
}

class Jacket(
    name: String,
    size: Size,
    price: Double,
    stock: Int
) : Clothing(name, size, ClothingType.JACKET, price, stock) {

    override fun tryOn() {
        println("Tying on jacket: $name (Size: $size)")
    }

    override fun purchase() {
        if (stock > 0) {
            stock--
            println("Jacket '$name' purchased successfully")
        } else {
            println("Jacket '$name' is out of stock.")
        }
    }

    override fun description(): String {
        return "$name is a warm, comfortable jacket in size $size."
    }
}

object ClothingInventory {
    private val items = mutableListOf<Clothing>()

    fun addItem(item: Clothing) {
        items.add(item)
        println("Added '${item.name} to inventory.")
    }

    fun listAvailable() {
        println("🛍️ Available Clothing:")
        items.filter { it.stock > 0}.forEach {
            println("- ${it.name} (${it.type}, Size: ${it.size}) - \$${it.price}, Stock: ${it.stock}")
        }
    }

    fun checkStatus(item: Clothing) : ClothingStaus {
        return when {
            item.stock == 0 -> ClothingStaus.OutOfStock
            item.name.contains("damaged", ignoreCase = true) -> ClothingStaus.Damaged("Visible tears")
            else -> ClothingStaus.Available
        }
    }
}





















