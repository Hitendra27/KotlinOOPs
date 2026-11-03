fun main() {
    val payment1: Payment = CardPayment()
    val payment2: Payment = PayPalPayment()
    val payment3: Payment = CashPayment()
    val payment4: Payment = BankTransferPayment()

    payment1.processPayment()
    payment2.processPayment()
    payment3.processPayment()
    payment4.processPayment()
}

abstract class Payment {
    abstract fun processPayment()
}

class CardPayment() : Payment() {
    override fun processPayment() {
        println("Card payment successful")
    }
}

class PayPalPayment() : Payment() {
    override fun processPayment() {
        println("PayPal payment successful")
    }
}

class CashPayment() : Payment() {
    override fun processPayment() {
        println("Cash payment successful")
    }
}

class BankTransferPayment() : Payment() {
    override fun processPayment() {
        println("Bank transfer successful")
    }
}









































