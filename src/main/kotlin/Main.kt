fun main() {
    val prices = mutableListOf(45, 120, 15, 300, 80, 25, 200)

    var largest = prices[0]
    var smallest = prices[0]
    var total = 0

    for (price in prices) {
        total += price

        if (largest < price) {
            largest = price
        }

        if (smallest > price) {
            smallest = price
        }
    }

    val averagePrice = total.toDouble() / prices.size

    println("Total: $total")
    println("Highest price: $largest")
    println("Lowest price: $smallest")
    println("The average price: $averagePrice")
}






































