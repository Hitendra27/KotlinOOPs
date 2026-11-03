fun main() {
    val prices = mutableListOf(20, 75, 30, 120, 50, 200)

    var total = 0
    var expensiveCount = 0
    var affordableCount = 0

    for (price in prices) {
        total += price

        if (price > 50) {
            expensiveCount++
        } else {
            affordableCount++
        }
    }

    val average = total.toDouble() / prices.size

    println("Total basket value: $total")
    println("Expensive products: $expensiveCount")
    println("Affordable products: $affordableCount")
    println("Average product price: $average")
}






































