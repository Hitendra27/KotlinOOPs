import com.sun.org.apache.xpath.internal.operations.And

fun main() {
    val account1 = BankAccount("Alex", 1000.0)

    account1.deposit(500.0)
    println(account1.accountHolder)
    println(account1.balance)

}

class BankAccount(
    val accountHolder: String,
    balance: Double
) {
    var balance: Double = balance
        private set

    fun deposit(amount: Double) {
        if (amount > 0) {
            balance += amount
        } else {
            println("Invalid deposit amount")
        }
    }
}













































