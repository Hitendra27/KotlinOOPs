fun main() {

    val owner = PhoneOwner("Alice", "+123456789")
    val androidPhone = AndroidPhone("Pixel 7", "14")
    val ipone = Iphone("iphone 15,", "7")

    val cureentState: PhoneState = PhoneState.AirplaneMode("10.30 AM")

    println("Owner: ${owner.name}, Phone: ${androidPhone.model}")
    androidPhone.call(owner.phoneNumber)
    androidPhone.text(owner.phoneNumber, "Hello from Kotlin")

    println("Owner: ${owner.name}, Phone: ${ipone.model}")
    ipone.call(owner.phoneNumber)

    // Check phone state
    when (cureentState) {
        is PhoneState.On -> println("Phone is On")
        is PhoneState.Off -> println("Phone is off")
        is PhoneState.AirplaneMode -> println("Phone is in Airplane Mode sice ${cureentState.enabledTime}")
    }

    println("Android Os: ${androidPhone.getOS()}")
    println("iPhone OS: ${ipone.getOS()}")
}

interface PhoneFeatures {
    fun call(number: String)
    fun text(number: String, message: String)
}

enum class PhoneBrand {
    SAMSUNG, APPLE, GOOGLE, ONEPLUS
}

abstract class Phone(
    val brand: PhoneBrand,
    val model: String,
) : PhoneFeatures {
    abstract fun getOS(): String
}

data class PhoneOwner(
    val name: String,
    val phoneNumber: String
)

sealed class PhoneState {
    object On : PhoneState()
    object Off : PhoneState()
    data class AirplaneMode(
        val enabledTime: String
    ) : PhoneState()
}

class AndroidPhone(
    model: String,
    val version: String
) : Phone(PhoneBrand.GOOGLE, model) {

    override fun getOS() = "Android $version"

    override fun call(number: String) {
        println("Calling $number using Android phone....")
    }

    override fun text(number: String, message: String) {
        println("Sending text to $number: $message")
    }
}

class Iphone(
    model: String,
    val iosVersion: String
) : Phone(PhoneBrand.APPLE, model) {

    override fun getOS(): String {
         return "iOS $iosVersion"
    }

    override fun call(number: String) {
        println("Calling $number using Android phone...")
    }

    override fun text(number: String, message: String) {
       println("Sending text to $number: $message")
    }
}

















