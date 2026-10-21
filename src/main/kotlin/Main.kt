import com.sun.org.apache.xpath.internal.operations.And

fun main() {
    val product1 = Product("Wireless Headphones", 80)
}

class Product(
    val name: String,
    val price: Int
) {
    init {
        println("Product created: $name")
    }
}

















