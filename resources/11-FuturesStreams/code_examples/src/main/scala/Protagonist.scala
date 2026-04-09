case class Protagonist(firstName: String, lastName: String, age: Int) {
  def toLine: String = s"$firstName,$lastName,$age"
  def toList: List[String] = List(firstName, lastName, age.toString)
}

object Protagonist {
  def fromLine(line: String): Protagonist = {
    val list = line.split(",").toList
    fromList(list)
  }
  
  def fromList(list: List[String]): Protagonist =
    Protagonist(list(0), list(1), list(2).toInt)
}

