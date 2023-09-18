object TemperatureConverter extends App {
  def calculateAverage(temperatures: List[Double]): Double = {
    val fahrenheitTemps = temperatures.map(celsius => (celsius * 9/5) + 32)
    val totalFahrenheit = fahrenheitTemps.reduce(_ + _)
    val averageFahrenheit = totalFahrenheit / temperatures.length.toDouble 
    averageFahrenheit
  }

  val temperatures = List(0.0, 10.0, 20.0, 30.0)
  val averageFahrenheit = calculateAverage(temperatures)
  println(s"Average Fahrenheit temperature: $averageFahrenheit")
}
