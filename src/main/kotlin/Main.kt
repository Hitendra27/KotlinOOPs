import com.sun.org.apache.xpath.internal.operations.And

fun main() {

    val bookTitle = "The Alchemist"
    val bookPrice = 12.0
    val quantity = 3
    val inStock = true

    val totalCost = bookPrice * quantity

    println(bookTitle)
    println(totalCost)

    if (inStock && quantity > 0) {
        println("Purchase allowed!")
    } else {
        println("Purchase denied.")
    }
}


