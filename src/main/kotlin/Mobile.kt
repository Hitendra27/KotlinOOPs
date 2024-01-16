class Mobile {

    var brand: String = ""
    var model: String = ""
    var mrp: Float = 0f
    var discount: Float = 0f

    fun getActualPrice(): Float {
        return mrp - discount
    }

    fun printDetails() {
        println("Mobile details:")
        println("Brand: $brand")
        println("Model:  $model")
        println("MRP: £ $mrp")
        println("Discount: £ $discount")
    }

}