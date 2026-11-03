import com.sun.org.apache.xpath.internal.operations.And

fun main() {
    val account1 = BankAccount("Alex", 1500.0)

    account1.displayAccountSummary()
    account1.withdraw(-100.0)
    account1.withdraw(300.00)
    println(account1.balance)
    account1.displayAccountSummary()

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

    fun withdraw(amount: Double) {
        if (amount > 0 && balance >= amount) {
            balance -= amount
        } else if (amount <= 0) {
            println("Invalid withdrawal amount")
        } else {
            println("Not enough money in account")
        }
    }

    fun displayAccountSummary() {
        println("Account holder: $accountHolder")
        println("Current balance: $balance")
    }
}











































