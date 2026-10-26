import com.sun.org.apache.xpath.internal.operations.And

fun main() {
    val payment1 = PaymentStatus.REFUNDED

    when (payment1) {
        PaymentStatus.PENDING -> println("Payment is pending")
        PaymentStatus.PAID -> println("Payment is paid")
        PaymentStatus.FAILED -> println("Payment is failed")
        PaymentStatus.REFUNDED -> println("Payment has been refunded")

    }
}

enum class PaymentStatus {
    PENDING,
    PAID,
    FAILED,
    REFUNDED
}




























