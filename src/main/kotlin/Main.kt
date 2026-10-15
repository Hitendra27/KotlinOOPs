import com.sun.org.apache.xpath.internal.operations.And

fun main() {
    val myNovel = Novel(
        "The Alchemist",
        "Paulo Coelho",
        208
    )

    myNovel.displayDetails()

    println()

    myNovel.updatePages(220)

    myNovel.displayDetails()

}

class Novel(
    val title: String,
    val author: String,
    var pages: Int
) {
    fun updatePages(newPages: Int) {
        require(newPages > 0) {
            "Pages must be greater than zero."
        }

        pages = newPages
    }
    fun displayDetails() {
        println("Title: $title")
        println("Author: $author")
        println("Pages: $pages")
    }
}