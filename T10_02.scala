object LetterCounter extends App {
  def countLetterOccurrences(words: List[String]): Int = {
    val letterCounts = words.map(_.length)
    val totalLetterOccurrences = letterCounts.reduce(_ + _)
    totalLetterOccurrences
  }

  val words = List("apple", "banana", "cherry", "date")
  val totalOccurrences = countLetterOccurrences(words)
  println(s"Total count of letter occurrences: $totalOccurrences")
}