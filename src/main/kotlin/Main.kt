import com.sun.org.apache.xpath.internal.operations.And

fun main() {
    val payment1 = PaymentStatus.FAILED
    val payment2 = PaymentStatus.FAILED
    val payment3 = PaymentStatus.PENDING

    if (
        (payment1 == PaymentStatus.PAID &&
        payment2 == PaymentStatus.FAILED)
        ||
        payment3 == PaymentStatus.REFUNDED
        ) {
        println("NovaCart requires a payment review")
    } else {
        println("All payments are clear")
    }

}

enum class PaymentStatus {
    PENDING,
    PAID,
    FAILED,
    REFUNDED
}






























