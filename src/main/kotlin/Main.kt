import com.sun.org.apache.xpath.internal.operations.And

fun main() {
    val novel1 = Novel(
        "The Alchemist",
        "Paulo Coelho",
        208
    )

    val novel2 = Novel(
        "New Mystery Novel",
        "Ruth Ware"
    )

    println(novel1.title)
    println(novel1.pages)
    println()
    println(novel2.title)
    println(novel2.pages)
}

class Novel(
    val title: String,
    val author: String,
    val pages: Int
) {
    constructor(title: String, author: String) :
        this(title, author, 0)

}


