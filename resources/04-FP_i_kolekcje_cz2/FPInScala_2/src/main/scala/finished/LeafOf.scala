package main.scala.finished

object LeafOf {
  type HeadOf[T] = T match {
    case Iterable[a] => Option[a]
    case String => Option[Char]
    case _ => T
  }

  def headOf[T](t: T): HeadOf[T] = t match {
    case it: Iterable[_] => it.headOption
    case str: String => str.headOption
    case _ => t
  }

  type LeafOf[T] = T match {
    case Iterable[a] => LeafOf[a]
    case _ => T
  }

  @main def main(): Unit = {
    val list: List[List[Int]] = List(List(1, 2, 3), List(4, 5, 6))
    val res: Option[List[Int]] = headOf(list)
    println(s"res: $res")

    val c: LeafOf[List[List[String]]] = "c"
  }

}
