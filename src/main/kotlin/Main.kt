import com.sun.org.apache.xpath.internal.operations.And

fun main() {

    for (basketTotal in 20..100 step 20) {
        val deliveryCost = calculateDelivery(basketTotal)
        println("Basket: £$basketTotal, Delivery: £$deliveryCost")
    }

}

fun calculateDelivery(basketTotal: Int): Int {
    if (basketTotal >= 50) {
        return 0
    } else {
        return 5
    }
}
























