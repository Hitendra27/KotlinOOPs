fun main() {

    val product = "Laptop"
    val price = 750
    val stock = 5
    val orderStatus = "PAID"
    val paymentMethod = "Card"

    when (orderStatus) {
        "PENDING" -> println("payment is pending")
        "PAID" -> println("payment paid")
        "FAILED" -> println("payment has been failed")
        else -> println("payment has been refunded")
    }

}



























