fun main() {

    val tesla = Sedan(
        brand = "Tesla",
        model = "Model S",
        fuelType = FuelType.ELECTRIC,
        specs = CarSpecs(horsepower = 670, weighKg = 2200, fuelEfficiency = 5.0),
        luxuryLevel = "Premium"
    )

    val jeep = SUV(
        brand = "Jeep",
        model = "Wrangler",
        fuelType = FuelType.DIESEL,
        specs = CarSpecs(horsepower = 285, weighKg = 1960, fuelEfficiency = 10.0),
        fourWheelDrive = true
    )

    println(tesla.getDescription())
    println(tesla.drive())

    println(jeep.getDescription())
    println(jeep.drive())

    val event: CarEvent = CarEvent.CarStarted(tesla)

    when (event) {
        is CarEvent.CarStarted -> println("${event.car.model} has started.")
        is CarEvent.CarStopped -> println("${event.car.model} has stopped.")
        is CarEvent.CarCrashed -> println("${event.car.model} crashed! Severity: ${event.severity}")
        CarEvent.NoEvent -> println("No car event occurred")
    }

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

class SUV(
    brand: String,
    model: String,
    fuelType: FuelType,
    specs: CarSpecs,
    val fourWheelDrive: Boolean
) : Car(brand, model, fuelType, specs) {

    override fun getDescription(): String {
        val driveType = if (fourWheelDrive) "4WD" else "2WD"
        return "$brand $model is an SUV with $driveType system and ${specs.horsepower} HP."
    }

    override fun drive(): String {
        return "Cruising $brand $model off-read."
    }
}

sealed class CarEvent {
    data class CarStarted(val car: Car) : CarEvent()
    data class CarStopped(val car: Car) : CarEvent()
    data class CarCrashed(val car: Car, val severity: String): CarEvent()
    object NoEvent: CarEvent()
}

















