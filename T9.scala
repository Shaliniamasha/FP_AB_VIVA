class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator must be nonzero")
  private val gcdVal = gcd(n.abs, d.abs)
  val numer: Int = n / gcdVal
  val denom: Int = d / gcdVal

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def neg: Rational = new Rational(-numer, denom)

  def sub(other: Rational): Rational = new Rational(
    numer * other.denom - other.numer * denom,
    denom * other.denom
  )

  override def toString: String = s"$numer/$denom"
}

class Account(initialBalance: Double) {
  private var balance: Double = initialBalance

  def deposit(amount: Double): Unit = {
    require(amount > 0, "Deposit amount must be positive")
    balance += amount
  }

  def withdraw(amount: Double): Unit = {
    require(amount > 0, "Withdrawal amount must be positive")
    require(balance >= amount, "Insufficient balance")
    balance -= amount
  }

  def transfer(amount: Double, targetAccount: Account): Unit = {
    require(amount > 0, "Transfer amount must be positive")
    require(balance >= amount, "Insufficient balance for transfer")
    balance -= amount
    targetAccount.deposit(amount)
  }

  def applyInterest(): Unit = {
    val interestRate = if (balance >= 0) 0.05 else 0.1
    balance += balance * interestRate
  }

  def getBalance: Double = balance
}

object Bank {
  def negativeBalanceAccounts(accounts: List[Account]): List[Account] =
    accounts.filter(_.getBalance < 0)

  def totalBalance(accounts: List[Account]): Double =
    accounts.map(_.getBalance).sum

  def applyInterestToAccounts(accounts: List[Account]): Unit =
    accounts.foreach(_.applyInterest())
}

object Main extends App {
  val x = new Rational(3, 4)
  val y = new Rational(5, 8)
  val z = new Rational(2, 7)

  val xyMinusZ = x.sub(y).sub(z)
  println(s"Result of x*y - z: $xyMinusZ")

  val account1 = new Account(1000)
  val account2 = new Account(500)
  account1.transfer(200, account2)

  val accounts = List(account1, account2)

  println(s"Accounts with negative balances: ${Bank.negativeBalanceAccounts(accounts)}")
  println(s"Total balance of all accounts: ${Bank.totalBalance(accounts)}")

  Bank.applyInterestToAccounts(accounts)
  println("Balances after applying interest:")
  accounts.foreach(account => println(s"Account balance: ${account.getBalance}"))
}