

fun main() {

    val movie1 = Movie("Interseller", "Sci-Fi", 8.5)
    println(movie1.getDetails())
    println()

    val movie2 = Movie("Shutter Island", "Thriller", 9.3)
    println(movie2.getDetails())
    println()

    val action = ActionMovie("John Wick")
    val comedy = ComedyMovie("Superbad")

    showTrailer(action)
    showTrailer(comedy)
    println()

    val people = listOf(
        Director("Christopher Nolan"),
        Actor("Leonardo DiCaprio")
    )

    for (person in people) {
        person.role()
    }

}

class Movie(
    private val title: String,
    private val genre: String,
    private var rating: Double
) {
    fun getDetails(): String {
        return "Movie: $title\nGenre: $genre\nRating: $rating"
    }

    fun updateRating(newRating: Double) {
        if (newRating in 0.0..10.0) {
            rating = newRating
        } else {
            println("Invalid rating. must be between 0.0 and 10.0")
        }
    }
}

open class MovieBase(
    val title: String,
    val genre: String
) {
    open fun playTrailer() {
        println("Playing trailer for $title")
    }
}

class ActionMovie(
    title: String
) : MovieBase(title, "Action") {
    override fun playTrailer() {
        println("💥 Explosions! Playing action trailer for $title")
    }
}

class ComedyMovie(
    title: String
) : MovieBase(title, "Comedy") {
    override fun playTrailer() {
        println("😂 Jokes! Playing comedy trailer for $title")
    }
}

fun showTrailer(movie: MovieBase) {
    movie.playTrailer()
}

val movies = listOf(
    ActionMovie("Mad Max"),
    ComedyMovie("The Office"),
    ActionMovie("The Matrix")
)

abstract class Person(
    val name: String
) {
    abstract fun role()
}

class Director(name: String) : Person(name) {
    override fun role() {
        println("$name is directing the movie.")
    }
}

class Actor(name: String) : Person(name) {
    override fun role() {
        println("$name is acting in the movie.")
    }
}
