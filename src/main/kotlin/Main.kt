fun main() {

    val games : List<Game> = listOf(
        ActionGame("Battle Zone"),
        PuzzleGame("Brain Teaser")
    )

    games.forEach {game ->
        val result = game.play()
        println("Game; ${game.name} [${game.genre}]")
        println("Result: ${result.message}, Score: ${result.score}")
        println()
    }
}

// Enum class
enum class GameGenre {
    ACTION, ADVENTURE, PUZZLE, RPG, SPORTS
}

// Base class - Abstract class
abstract class Game(
    val name: String,
    val genre: GameGenre
) {
    abstract fun play(): GameResult
}

// data class
data class GameResult(
    val success: Boolean,
    val score: Int,
    val message: String
)

// Subclass 1 - Action Game
class ActionGame(
    name: String
) : Game(name, GameGenre.ACTION) {

    override fun play(): GameResult {
        return GameResult(true, 850, "$name played with intense action")
    }
}

// Subclass 2 - Puzzle Game
class PuzzleGame(
    name: String
) : Game(name, GameGenre.PUZZLE) {

    override fun play(): GameResult {
        return GameResult(true, 650, "$name solved with cleaver thinking!")
    }
}









