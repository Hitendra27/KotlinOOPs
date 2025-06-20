
import java.util.*
fun main() {

    val customer = Customer("Olivia", "C204")

    val shirt = Shirt("Casual Shirt", Size.M, 29.99, 2)
    val jacket = Jacket("Winter Jacket", Size.L, 89.99, 1)

    ClothingInventory.addItem(shirt)
    ClothingInventory.addItem(jacket)

    ClothingInventory.listAvailable()

    println("\nCustomer: ${customer.name} is shopping...")

    shirt.tryOn()
    shirt.purchase(customer)

    jacket.tryOn()
    jacket.purchase(customer)

    println("\\n\uD83C\uDFAF Reward Points: ${customer.rewardPoints}")

    println("\nAttempting to return the jacket:")
    jacket.returnItem(customer)

    println("\\n\uD83C\uDFAF Reward Points after return: ${customer.rewardPoints}")

    ClothingInventory.listAvailable()

    // Filtering
    ClothingInventory.filterBySize(Size.M)
    ClothingInventory.filterByType(ClothingType.JACKET)
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

sealed class ClothingStatus {
    object Available: ClothingStatus()
    object OutOfStock: ClothingStatus()
    data class Damaged(val reason: String): ClothingStatus()
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
        stock++
        if (customer.purchaseHistory.remove(this)) {
            customer.rewardPoints -= 10
            println("Returned '$name'. -10 reward points.")
        } else {
            println("This shirt wasn't purchased by ${customer.name}")
        }
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

    override fun purchase(customer: Customer) {
        if (stock > 0) {
            stock--
            customer.purchaseHistory.add(this)
            customer.addPoints(15)
            println("Jacket '$name' purchased. +15 reward points.")
        } else {
            println("Jacket '$name' is out of stock.")
        }
    }

    override fun returnItem(customer: Customer) {
        stock++
        if (customer.purchaseHistory.remove(this)) {
            customer.rewardPoints -= 15
            println("Returned '$name'. -15 reward points.")
        } else {
            println("This jacked wasn't purchased by ${customer.name}.")
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
        println("Added '${item.name}' to inventory.")
    }

    fun listAvailable() {
        println("🛍️ Available Clothing:")
        items.filter { it.stock > 0 }.forEach {
            println("- ${it.name} (${it.type}, Size: ${it.size}) - \$${it.price}, Stock: ${it.stock}")
        }
    }

    fun checkStatus(item: Clothing) : ClothingStatus {
        return when {
            item.stock == 0 -> ClothingStatus.OutOfStock
            item.name.contains("damaged", ignoreCase = true) -> ClothingStatus.Damaged("Torn fabric")
            else -> ClothingStatus.Available
        }
    }

    fun filterBySize(size: Size) {
        println("\\n\uD83D\uDCCF Filtered by size: $size")
        items.filter { it.size == size && it.stock > 0 }.forEach {
            println("- ${it.name} (${it.type}) - \$${it.price}")
        }
    }

    fun filterByType(type: ClothingType) {
        println("\\n\uD83D\uDC55 Filtered by type: $type")
        items.filter { it.type == type && it.stock > 0 }.forEach {
            println("- ${it.name} (Size: ${it.size}) - \$${it.price}")
        }
    }
}





















