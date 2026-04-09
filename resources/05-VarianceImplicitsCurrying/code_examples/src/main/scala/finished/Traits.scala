package org.fpinscala.finished

// 11.2

object Traits {
  sealed trait Tree[+T]
  case class Branch[T](left: Tree[T], value: T, right: Tree[T]) extends Tree[T]
  case class Leaf[T](value: T) extends Tree[T]
  case object Stump extends Tree[Nothing]

  /*
      3
     / \
    2   5
   /   / \
  1   4   6
  */

  val intTree: Tree[Int] =
    Branch(
      Branch(Leaf(1), 2, Stump),
      3,
      Branch(Leaf(4), 5, Leaf(6))
    )

  // print out the tree
  def print[T](tree: Tree[T], toString: T => String, level: Int = 0): Unit = {
    val prefix = Seq.fill(level)('-').mkString
    tree match { // show match exhaustive!
      case Branch(left, value, right) =>
        println(s"$prefix${toString(value)}")
        print(left, toString, level + 1)
        print(right, toString, level + 1)
      case Leaf(value) =>
        println(s"$prefix${toString(value)}")
      case Stump =>
        println(s"${prefix}X")
    }
  }

  def add[T](tree: Tree[T], t: T, compare: (T, T) => Int): Tree[T] = tree match {
    case Branch(left, value, right) if compare(t, value) < 0 =>
      val newLeft = add(left, t, compare)
      Branch(newLeft, value, right)
    case Branch(left, value, right) if compare(t, value) > 0 =>
      val newRight = add(right, t, compare)
      Branch(left, value, newRight)
    case branch@Branch(_, _, _) =>
      branch // no changes
    case Leaf(value) if compare(t, value) < 0 =>
      Branch(Leaf(t), value, Stump)
    case Leaf(value) if compare(t, value) > 0 =>
      Branch(Stump, value, Leaf(t))
    case leaf@Leaf(_) =>
      leaf // no changes
    case _ =>
      Leaf(t)
  }

  def add[T](tree: Tree[T], values: Seq[T], compare: (T, T) => Int): Tree[T] =
    values.foldLeft[Tree[T]](tree) { (tree, t) => add(tree, t, compare) }

  def create[T](values: Seq[T], compare: (T, T) => Int): Tree[T] = add(Stump, values, compare)

/*  @main def main(): Unit = {
    val compare = (a: Int, b: Int) => a - b
    val toString = (n: Int) => n.toString
    print(intTree, toString)
    val newTree = create(Seq(10, 5, 15, 2, 8), compare)
    print(newTree, toString)
  }*/
}
