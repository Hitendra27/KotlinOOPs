import com.sun.org.apache.xpath.internal.operations.And

fun main() {

    val mouse = PhysicalProduct(
        "Wireless Mouse",
        75,
        20,
        "Electronics"
    )

    println(mouse.productName)
    println(mouse.productCategory)
    mouse.displayStock()
    mouse.displayProductDetails()

    //println(mouse.productCost)
}

open class Product(
    public val productName: String,
    private val productCost: Int,
    protected var stockQuantity: Int,
    internal val productCategory: String
) {}


class PhysicalProduct(
    productName: String,
    productCost: Int,
    stockQuantity: Int,
    productCategory: String
) : Product(productName, productCost, stockQuantity, productCategory) {

    fun displayStock() {
        println(stockQuantity)
    }

    fun displayProductDetails() {
        println(productName)
        println(productCategory)
    }
}











































