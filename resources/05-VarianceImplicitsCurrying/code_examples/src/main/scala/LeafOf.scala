package main.scala

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

  val leafOf: LeafOf[Int] = 42
  val leafOfString: LeafOf[String] = "Hello"

  def leafOfIntToString(leaf: LeafOf[Int]): LeafOf[String] = leaf.toString
  def leafToString(leaf: LeafOf[Int]): String = leaf.toString
  def leafToString(leaf: LeafOf[String]): String = leaf.toString
  def leafToString(leaf: LeafOf[LeafOf[Int]]): String = leaf.toString
}
