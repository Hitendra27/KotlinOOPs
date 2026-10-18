import com.sun.org.apache.xpath.internal.operations.And

fun main() {

    val productName = "Wireless Headphones"
    val price = 80.0
    val quantityInStock = 5
    val customerMoney = 100.0

    val totalPrice = price * 2

    if (customerMoney >= totalPrice && quantityInStock >= 2) {
        println("Purchase successful!")
    } else if (customerMoney >= totalPrice) {
        println("Not enough stock!")
    } else {
        println("Insufficient funds!")
    }

    println(productName)
    println(totalPrice)
}


