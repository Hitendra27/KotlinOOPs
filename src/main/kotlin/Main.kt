import com.sun.org.apache.xpath.internal.operations.And

fun main() {

    val owner = PhoneOwner("Alice", "+123456789")
    val androidSpecs = PhoneSpecs(123, 8, true)
    val iosSpecs = PhoneSpecs(256, 6, true)

    val androidPhone = AndroidPhone("Pixel 7", PhoneBrand.GOOGLE, androidSpecs)
    val iPhone = Ipone("iPhone 16", iosSpecs)

    val currentState: PhoneState = PhoneState.AirplaneMode("10:30 AM")

    println("\uD83D\uDCF1 Owner: ${owner.name}")
    println(androidPhone.about())
    androidPhone.call(owner.phoneNumber)
    androidPhone.text(owner.phoneNumber, "Hey there!")

    println(iPhone.about())
    iPhone.call(owner.phoneNumber)

    when (currentState) {
        is PhoneState.On -> println("Phone is On")
        is PhoneState.Off -> println("Phone is off")
        is PhoneState.AirplaneMode -> println("\uD83D\uDCF4 Airplane Mode enabled since ${currentState.enabledTime}")
    }

    println("\uD83D\uDD27 Android OS: ${androidPhone.getOS()}")
    println("\uD83D\uDD27 iPhone OS: ${iPhone.getOS()}")
}

interface Callable {
    fun call(number: String)
    fun text(number: String, message: String)
}

enum class PhoneBrand {
    SAMSUNG, APPLE, GOOGLE, ONEPLUS, NOKIA
}

enum class OperatingSystem {
    ANDROID, IOS, HARMONY_OS
}

data class PhoneSpecs(
    val storageGB: Int,
    val ramGB: Int,
    val has5G: Boolean
)

data class PhoneOwner (
    val name: String,
    val phoneNumber: String
)

sealed class PhoneState {
    object On : PhoneState()
    object Off : PhoneState()
    data class AirplaneMode(val enabledTime: String) : PhoneState()
}

abstract class MobilePhone(
    val model: String,
    val brand: PhoneBrand,
    val specs: PhoneSpecs
) : Callable {
    abstract fun getOS(): OperatingSystem
    abstract fun about(): String
}

class AndroidPhone(
    model: String,
    brand: PhoneBrand,
    specs: PhoneSpecs
) : MobilePhone(model, brand, specs) {
    override fun getOS(): OperatingSystem = OperatingSystem.ANDROID

    override fun call(number: String) {
        println("\uD83D\uDCDE Calling $number from Android phone: $model")
    }

    override fun text(number: String, message: String) {
        println("\uD83D\uDCAC Sending text from Android phone to $number: $message")
    }

    override fun about(): String {
        return "Android Phone: $brand $model, Specs: ${specs.ramGB}GB RAM, ${specs.storageGB}GB Storage, 5G: ${specs.has5G}"
    }
}

class Ipone(
    model: String,
    specs: PhoneSpecs
) : MobilePhone(model, PhoneBrand.APPLE, specs) {
    override fun getOS(): OperatingSystem = OperatingSystem.IOS

    override fun call(number: String) {
        println("\uD83D\uDCDE Calling $number from iPhone: $model")
    }

    override fun text(number: String, message: String) {
       println("\uD83D\uDCAC iMessage to $number: $message")
    }

    override fun about(): String {
        return "iPhone: $model, Specs: ${specs.ramGB}GB RAM, ${specs.storageGB}GB Storage, 5G: ${specs.has5G}"
    }
}