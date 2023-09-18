object Q3 {

  val toUpper: (String, Int, Int) => String = (name, start, end) => {
    if (start <= end) {
      val modifiedName = name.updated(start, name.charAt(start).toUpper)
      toUpper(modifiedName, start + 1, end)
    } else name
  }

  val toLower: (String, Int, Int) => String = (name, start, end) => {
    if (start <= end) {
      val modifiedName = name.updated(start, name.charAt(start).toLower)
      toLower(modifiedName, start + 1, end)
    } else name
  }

  val formatNames = (name:String, start: Int, end: Int, f:(String,Int,Int)=>String) => f(name, start, end)

  def main(args: Array[String]):Unit={
    println(formatNames("Benny", 0, 4 , toUpper))
    println(formatNames("Niroshan", 0, 1 , toUpper))
    println(formatNames("Saman", 0, 0 , toLower))
    println(formatNames("Kumara", 5, 5 , toUpper))
  }

}