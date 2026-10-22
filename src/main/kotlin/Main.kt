import com.sun.org.apache.xpath.internal.operations.And

fun main() {
    val product1 = Product("Headphones", 80)

    product1.price = 75

    println(product1.name)
    println(product1.price)
}

class Product(
    val name: String,
    var price: Int
) {
    init {
        require(price >= 0)
    }
}





















