import com.sun.org.apache.xpath.internal.operations.And

fun main() {

    // Data class
    val learner = Learner(
        name = "Hitendra",
        age = 30,
        nativeLanguage = "English"
    )

    // Languages
    val french = French(Level.B1)
    val portuguese = Portuguese(Level.A1)
    val spanish = Spanish(Level.A1)

    // Sealed class
    val frenchState: LearningState =
        LearningState.Learning(70)

    println("Learner: ${learner.name}")
    println("Native language: ${learner.nativeLanguage}")

    println()

    // French
    french.showInformation()
    french.speak()
    french.greet()
    println(french.grammer())

    println()

    // Portuguese
    portuguese.showInformation()
    portuguese.speak()
    portuguese.greet()

    println()

    // Spanish
    spanish.showInformation()
    spanish.speak()
    spanish.greet()

    println()

    // Sealed class + when
    when (frenchState) {

        is LearningState.NotStarted ->
            println("French learning has not started.")

        is LearningState.Learning ->
            println("French progress: ${frenchState.progress}")

        is LearningState.Completed ->
            println("French course completed!")

        is LearningState.Failed ->
            println("Learning failed: ${frenchState.reason}")

    }
}

interface Speakable {

    fun speak()
    fun greet()
}

enum class LanguageType {
    FRENCH,
    PORTUGUESE,
    SPANISH
}

enum class Level {
    A1,
    A2,
    B1,
    B2,
    C1,
    C2
}

data class Learner (
    val name: String,
    val age: Int,
    val nativeLanguage: String
)

sealed class LearningState {

    object NotStarted : LearningState()

    data class Learning(val progress: Int) : LearningState()

    object Completed : LearningState()

    data class Failed(val reason: String) : LearningState()
}

abstract class Language(
    val name: String,
    val type: LanguageType,
    val level: Level
) : Speakable {

    abstract fun grammer(): String

    fun showInformation() {
        println("Language: $name")
        println("Type: $type")
        println("Level: $level")
    }
}

class French(
    level: Level
) : Language(
    name = "French",
    type = LanguageType.FRENCH,
    level = level
){

    override fun speak() {
        println("Bonjour !")
    }

    override fun greet() {
        println("Comment allez-vous ?")
    }

    override fun grammer(): String {
        return "French uses masculine and feminine nouns."
    }
}

class Portuguese(
    level: Level
) : Language (
    name = "Portuguese",
    type = LanguageType.PORTUGUESE,
    level = level
) {

    override fun speak() {
        println("Olá!")
    }

    override fun greet() {
        println("Como você está?")
    }

    override fun grammer(): String {
        return "Portuguese has masculine and feminine nouns"
    }
}

class Spanish(
    level: Level
) : Language(
    name = "Spanish",
    type = LanguageType.SPANISH,
    level = level
) {
    override fun speak() {
        println("¡Hola!")
    }

    override fun greet() {
        println("¿Cómo estás?")
    }

    override fun grammer(): String {
        return "Spanish has masculine and feminine nouns."
    }
}