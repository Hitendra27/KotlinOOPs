import com.sun.org.apache.xpath.internal.operations.And

fun main() {

}

open class Novel(
    val title: String,
    protected val pages: Int = 208
) {

    fun displayTitle() {
        println("$title")
    }
}

class MysteryNovel() : Novel() {

    fun displayPages()
}






