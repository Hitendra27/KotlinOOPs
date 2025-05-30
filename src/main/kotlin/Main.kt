fun main() {

    val author1 = Author("Isaac Asimov", "USA")
    val author2 = Author("Liane Moriaty", "UK")
    val reader = Reader("Alice", "M001")

    val book1 = FictionBook("Foundation", author1)
    val book2 = ScienceBook("A Brief History of Time", author2)

    val status: BookStatus = BookStatus.Damaged("Water damage on back cover")

    println("Reader: ${reader.name} is checking books.")
    println("Book 1: ${book1.title}, Genre: ${book1.genre}")
    book1.read()
    book1.review(5)

    println("Book 2: ${book2.title}, Genre: ${book2.genre}")
    book2.read()

    when (status) {
        is BookStatus.Available -> println("The book is available")
        is BookStatus.Checkout -> println("The book is currently checked out.")
        is BookStatus.Damaged -> println("The book is damaged: ${status.reason}")
    }

    println(book1.summary())
    println(book2.summary())

}

interface Readable {
    fun read()
    fun review(rating: Int)
}

enum class Genre {
    FICTION, NON_FICTION, SCIENCE, HISTORY, FANTASY, BIOGRAPHY
}

abstract class Book(
    val title: String,
    val author: Author,
    val genre: Genre,
    val price: Double,
    val stock: Int
) : Readable{
    abstract fun summary(): String

    fun applyDiscount(percent: Double) {
        val discout = price * (percent / 100)
        price -= discout
    }
}

data class Author (
    val name: String,
    val nationality: String
)

data class Reader (
    val name: String,
    val memberId: String
)

sealed class BookStatus {
    object Available : BookStatus()
    object Checkout : BookStatus()
    data class Damaged(val reason: String) : BookStatus()
}

class FictionBook(
    title: String,
    author: Author
) : Book(
    title,
    author,
    Genre.FICTION
) {
    override fun summary(): String {
        return "$title is a thrilling story by ${author.name}"
    }

    override fun read() {
        println("Reading fiction book '$title'...")
    }

    override fun review(rating: Int) {
        println("You rated the fiction book '$title' with $rating stars.")
    }
}

class ScienceBook(
    title: String,
    author: Author
) : Book(title, author, Genre.SCIENCE) {
    override fun summary(): String {
        return "$title explores scientific concepts authored by ${author.name}"
    }

    override fun read() {
        println("Reading science book '$title'...")
    }

    override fun review(rating: Int) {
        println("You rated the science book '$title' with $rating stars.")
    }
}























