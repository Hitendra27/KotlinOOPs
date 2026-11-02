import com.sun.org.apache.xpath.internal.operations.And

fun main() {
    val myCar = Car("Toyota", 2025)
    println(myCar.brand)
    println(myCar.year)
}

open class Vehicle(
    val brand: String,
    val year: Int
) {}

class Car(
    brand: String,
    year: Int
): Vehicle(brand, year) {}












































