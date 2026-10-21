import com.sun.org.apache.xpath.internal.operations.And

fun main() {
    var total = 0
    var basketCount = 0
    var largest = 0
    var smallest = 100
    var counter = 0

    for (basketTotal in 10..100 step 10) {
        total += basketTotal
        basketCount++

        if (basketTotal > largest) {
            largest = basketTotal
        }

        if (basketTotal < smallest) {
            smallest = basketTotal
        }

        if (basketTotal >= 50) {
            counter++
        }
    }

    println("Total value: £$total")
    println("Basket count: $basketCount")
    println("Largest basket: £$largest")
    println("Smallest basket: £$smallest")
    println("Counter: $counter")
}













