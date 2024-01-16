fun main(args: Array<String>) {

    val mobile = Mobile()
    mobile.brand = "Iphone"
    mobile.model = "11 pro"
    mobile.mrp = 10000f
    mobile.discount = 1000f

    println("Discounted price is: ${mobile.getActualPrice()}")

    mobile.printDetails()

}