fun main() {

}

enum class FuelType {
    PETROL, DIESEL, ELECTRIC, HYBRID
}

data class CarSpecs(
    val horsepower: Int,
    val weighKg: Int,
    val fuelEfficiency: Double
)

interface Drivable {
    fun drive(): String
}

abstract class Car(
    val brand:String,
    val model: String,
    val fuelType: FuelType,
    val specs: CarSpecs
) : Drivable {
    abstract fun getDescription(): String
}

class Sedan(
    brand: String,
    model: String,
    fuelType: FuelType,
    specs: CarSpecs,
    val luxuryLevel: String
) : Car(brand, model, fuelType, specs) {

    override fun getDescription(): String {
        return "$brand $model is a $luxuryLevel sedan with ${specs.horsepower} HP." +
                "Fuel: ${fuelType.name}, Efficiency: ${specs.fuelEfficiency} km/l or km/kWh"
    }

    override fun drive(): String {
        return "Driving $brand $model smoothly on the highway."
    }
}

//class SUV() : Car() {}

















