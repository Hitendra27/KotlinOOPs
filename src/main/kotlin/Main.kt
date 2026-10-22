import com.sun.org.apache.xpath.internal.operations.And

fun main() {

    val product1 = Product("Keyboard", 45)
    val product2 = Product("Mouse", -5)

    println(product1.name)
    println(product1.price)
    println()
    println(product2.name)
    println(product2.price)
}

class Product(
    val name: String,
    val price: Int
) {
    init {
        require(price >= 0) {
            "Price cannot be negative"
        }
    }
}



















