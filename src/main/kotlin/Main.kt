import com.sun.org.apache.xpath.internal.operations.And

fun main() {}

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
