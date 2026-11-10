fun main() {

    val product = "Laptop"
    val price = 750
    val stock = 5
    val orderStatus = "PAID"
    val paymentMethod = "Card"

   val productMessage = if (stock > 0) {
       "Product available"
   } else {
       "Product unavailable"
   }

    println(productMessage)

}



























