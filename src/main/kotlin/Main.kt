fun main() {

    val customer = Customer("Emma", "C102")

    val shirt = Shirt("Casula Shirt", Size.M, 29.99, 2)
    val jacket = Jacket("Winter Jacket", Size.L, 89.99, 1)
    val damagedShirt = Shirt("Damaged Old Shirt", Size.S, 9.99, 1)

    ClothingInventory.addItem(shirt)
    ClothingInventory.addItem(jacket)
    ClothingInventory.addItem(damagedShirt)

    ClothingInventory.listAvailable()

    println("\nCustomer: ${customer.name} is trying on clothes.")

    shirt.tryOn()
    shirt.purchase()

    jacket.tryOn()
    jacket.purchase()
}

interface Wearable {
    fun tryOn()
    fun purchase()
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
    val membershipId: String
)

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

    override fun purchase() {
        if (stock > 0) {
            stock--
            println("Shirt '$name' purchased successfully.")
        } else {
            println("Shirt '$name' is out of stock." )
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





















