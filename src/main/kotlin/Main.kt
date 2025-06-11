fun main() {
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
        TODO("Not yet implemented")
    }

    override fun purchase() {
        TODO("Not yet implemented")
    }

    override fun description(): String {
        TODO("Not yet implemented")
    }
}





















