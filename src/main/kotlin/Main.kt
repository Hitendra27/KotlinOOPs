fun main() {

    val fiction = FictionBook("1984", "George Orwell", 1949, "Dystopian")
    val acedemic = AcademicBook("Clean Code", "Robert C. Martin", 2008, "Software Engineering")

    val library = Library()
    library.addBook(fiction)
    library.addBook(acedemic)

    library.showCatelog()

}

// Base class
open class Book(
    val title: String,
    val author: String,
    val year: Int
) {
    open fun geDescription(): String {
        return "'$title' by $author, published in $year"
    }
}

// Subclass
class FictionBook(
    title: String,
    author: String,
    year: Int,
    val genre: String
) : Book(title, author, year) {
    override fun geDescription(): String {
        return super.geDescription() + "- Genre: $genre"
    }
}

// Subclass 2
class AcademicBook(
    title: String,
    author: String,
    year: Int,
    val subject: String
) : Book(title, author, year) {
    override fun geDescription(): String {
        return super.geDescription() + " - Subject: $subject"
    }
}

// class demonstrating encapsulation
class Library {
    private val books = mutableListOf<Book>() // private property

    fun addBook(book: Book) {
        books.add(book)
        println("Book added: ${book.title}")
    }

    fun showCatelog() {
        println("Library Catalog:")
        books.forEach { println(it.geDescription()) }
    }
}









