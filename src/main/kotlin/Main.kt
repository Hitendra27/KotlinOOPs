
fun main() {
    tempCity("Ankara", 27, 31, 82)
    tempCity("Tokyo", 32, 36, 10)
    tempCity("Cape Town", 59, 64, 2)
    tempCity("Guatemala City", 50, 55, 7)

}

fun tempCity(cityName: String, lowTemp: Int, highTemp: Int, rain: Int) {
    println("City: $cityName")
    println("Low temperature: $lowTemp, High temprature: $highTemp")
    println("Chance of rain: $rain%")
    println()
}