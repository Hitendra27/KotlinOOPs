import com.sun.org.apache.xpath.internal.operations.And

fun main() {

}

interface Playable {
    fun play()
    fun pause()
}

enum class Genre {
    ACTION, COMEDY, DRAMA, HORROR, DOCUMENTARY
}

data class User(
    val name: String,
    val subscriptionType: String
)

sealed class PlaybackState {
    object Playing : PlaybackState()
    object Paused : PlaybackState()
    object Stopped : PlaybackState()
    data class Buffering(val percent: Int) : PlaybackState()
}

abstract class Content (
    val title : String,
    val genre: Genre
) : Playable {
    abstract fun getDescription(): String
}

class Movie(
    title: String,
    genre: Genre,
    val duration: Int
) : Content(title, genre) {

    override fun play() {
        println("▶️ Playing movie: $title")
    }

    override fun pause() {
        println("⏸️ Paused movie: $title")
    }

    override fun getDescription(): String {
        return "$title is a $genre movie, duration : $duration mins"
    }
}

class TVShow(
    title: String,
    genre: Genre,
    val seasons: Int
) : Content(title, genre) {

    override fun play() {
        println("▶️ Playing TV Show: $title")
    }

    override fun pause() {
        println("⏸️ Paused TV Show: $title")
    }

    override fun getDescription(): String {
        return "$title is a $genre show with $seasons seasons"
    }
}
