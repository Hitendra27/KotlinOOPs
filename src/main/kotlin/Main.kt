fun main() {
    val stock = mutableListOf(5, 0, 12, 3, 0, 20, 8)

    var totalStock = 0
    var outOfStockCount = 0
    var inStockCount = 0
    var largestStock = stock[0]
    var smallestStock = stock[0]

    for (item in stock) {
        totalStock += item

        if (item == 0) {
            outOfStockCount++
        }

        if (item > 0) {
            inStockCount++
        }

        if (item > largestStock) {
            largestStock = item
        }

        if (item < smallestStock && item > 0) {
            smallestStock = item
        }
    }

    println("Total stock: $totalStock")
    println("Out of stock products: $outOfStockCount")
    println("Products in stock: $inStockCount")
    println("Highest stock: $largestStock")
    println("Lowest available stock: $smallestStock")
}






































