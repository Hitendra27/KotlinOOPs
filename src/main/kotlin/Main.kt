import com.sun.org.apache.xpath.internal.operations.And

fun main() {
    val product1 = Product("Headphones", 75)
    val product2 = product1.copy(price = 65)

    println(product1)
    println(product2)
}

data class Product(
    val name: String,
    val price: Int
)






















