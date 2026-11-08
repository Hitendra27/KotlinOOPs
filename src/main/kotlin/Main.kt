fun main() {

    val firstName = "sanjay"
    val lastName = "quessou"

    fun String.capitalizeFirstLetter(): String {
        return this.replaceFirstChar { it.uppercase() }
    }

    val fullName = "${firstName.capitalizeFirstLetter()} ${lastName.capitalizeFirstLetter()}"

    println(fullName)

}

































