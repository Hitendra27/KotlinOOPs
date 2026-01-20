import com.sun.org.apache.xpath.internal.operations.And

fun main() {}

interface Wearable {
    fun wear()
}

enum class ShoeSize(val euSize: Int) {
    SMALL(40),
    MEDIUM(42),
    LARGE(44),
    XL(46)
}

abstract class NikeShoe(
    val model: String,
    val size: ShoeSize,
    val price: Double
) : Wearable{
    abstract fun category(): String
}

data class NikeRunningShoe(
    val runningModel: String,
    val shoeSize: ShoeSize,
    val shoePrice: Double,
    val cushioning: String
) : NikeShoe(runningModel, shoeSize, shoePrice) {

    override fun wear() {
        println("Wearing Nike Running Shoe: $runningModel, Size: ${size.euSize}")
    }

    override fun category(): String = "Running"
}

data class NikeBasketballShoe(
    val basketballModel: String,
    val shoeSize: ShoeSize,
    val shoePrice: Double,
    val ankleSupportLevel: String
) : NikeShoe(basketballModel, shoeSize, shoePrice) {

    override fun wear() {
        println("Wearing Nike Basketball Shoe: $basketballModel, Size: ${size.euSize}")
    }

    override fun category(): String = "Basketball"
}

sealed class ShoeStatus {
    object InStock : ShoeStatus()
    object SoldOut : ShoeStatus()
    data class Discounted(val percent: Int) : ShoeStatus()
}
