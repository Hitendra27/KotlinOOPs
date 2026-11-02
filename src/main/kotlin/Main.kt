import com.sun.org.apache.xpath.internal.operations.And

fun main() {
    val product1 = Product("Wireless Mouse", 2)

    product1.reduceStock()
    product1.displayStock()
    product1.reduceStock()
    product1.displayStock()
    product1.reduceStock()
}

class Product(
    val name: String,
    private var stock: Int
) {
    fun displayStock() {
        //println(name)
        println("$name - Stock remaining: $stock")
    }
    fun reduceStock() {
        if (stock > 0) {
            stock--
        } else {
            println("Sorry, out of stock!")
        }
    }
}



































