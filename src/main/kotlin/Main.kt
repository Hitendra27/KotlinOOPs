fun main() {
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

















