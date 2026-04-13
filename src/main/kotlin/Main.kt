import com.sun.org.apache.xpath.internal.operations.And

fun main() {}

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
