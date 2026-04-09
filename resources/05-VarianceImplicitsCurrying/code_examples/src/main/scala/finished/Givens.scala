package org.fpinscala.finished

object Givens {
  enum Tree[+T] { 
    case Branch(left: Tree[T], value: T, right: Tree[T])
    case Leaf(value: T)
    case Stump
  }

  enum TreeComparison {
    case Left, Equal, Right
  }
  
  import Tree.*
  import TreeComparison.*
  
  given compare: ((Int, Int) => TreeComparison) = {
    (a: Int, b: Int) =>
      if (a < b) Left
      else if (a > b) Right
      else Equal
  }

  // the name (toString) is unnecessary and can be dropped
  given (Int => String) = (n: Int) => n.toString
  
  def add[T](tree: Tree[T], t: T)(using compare: (T, T) => TreeComparison): Tree[T] = tree match {
    case Branch(left, value, right) if compare(t, value) == Left  => Branch(add(left, t), value, right)
    case Branch(left, value, right) if compare(t, value) == Right => Branch(left, value, add(right, t))
    case branch@Branch(_, _, _)                                   => branch // no changes
    case Leaf(value) if compare(t, value) == Left                 => Branch(Leaf(t), value, Stump)
    case Leaf(value) if compare(t, value) == Right                => Branch(Stump, value, Leaf(t))
    case leaf@Leaf(_)                                             => leaf // no changes
    case Tree.Stump                                               => Leaf(t)
  }

  def add[T](tree: Tree[T], values: Seq[T])(using compare: (T, T) => TreeComparison): Tree[T] =
    values.foldLeft[Tree[T]](tree) { (tree, t) => add(tree, t) }

  def create[T](values: Seq[T])(using compare: (T, T) => TreeComparison): Tree[T] = add(Stump, values)

  def print[T](tree: Tree[T], level: Int = 0)(using toString: T => String): Unit = {
    val prefix = Seq.fill(level)('-').mkString
    tree match { // show match exhaustive!
      case Branch(left, value, right) =>
        println(s"$prefix${toString(value)}")
        print(left, level + 1)
        print(right, level + 1)
      case Leaf(value) =>
        println(s"$prefix${toString(value)}")
      case Stump =>
        println(s"${prefix}X")
    }
  }
}
