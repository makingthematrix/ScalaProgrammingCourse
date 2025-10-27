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

}
