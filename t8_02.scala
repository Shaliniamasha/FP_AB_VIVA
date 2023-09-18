
import scala.io.StdIn.readInt //used to read an integer from the standard input 

object NumberClassifier extends App {
  val classifyNumber: Int => String = {
    case n if n <= 0 => "Negative/Zero is input"
    case n if n % 2 == 0 => "Even number is given"
    case n => "Odd number is given"
  }

  println("Enter an integer:")
  val input = readInt()
  val classification = classifyNumber(input)
  println(classification)
}
