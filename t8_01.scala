object InterestCalculator {
  val calculateInterest: Double => Double = deposit => {
    deposit match {
      case d if d <= 20000 => d * 0.02
      case d if d <= 200000 => d * 0.04
      case d if d <= 2000000 => d * 0.035
      case d => d * 0.065
    }
  }

  def main(args: Array[String]): Unit = {
    val depositAmounts = List(15000, 250000, 1500000, 3000000)
    
    depositAmounts.foreach { deposit =>
      val interestAmount = calculateInterest(deposit)
      println(s"Interest earned for Rs. $deposit: $interestAmount")
    }
  }
}
