package org.fpinscala

// 11

object Enums {
  enum Tree[+T] {
    case Branch(left: Tree[T], value: T, right: Tree[T])
    case Leaf(value: T)
    case Stump
  }

  /*
  Algebraic Data Types are usually implemented in Scala in two ways:
  1. Enums (Scala 3)
  2. Sealed trait hierarchies (Scala 2 & 3)

      3
     / \
    2   5
   /   / \
  1   4   6


  */

  import Tree.*
  val intTree =
    Branch(
      Branch(Leaf(1), 2, Stump),
      3,
      Branch(Leaf(4), 5, Leaf(6))
    )

/*
- 3
-- 2
--- 1
-- 5
--- 4
--- 6
*/

  private def compare(a: Int, b: Int): Int = a - b
  /*@main def main(): Unit = {
   val newTree =
     Seq(7, 2, 10, 10, 4, 6, 1, 12, 11)
       .foldLeft[Tree[Int]](Stump) { (tree, n) => add(tree, n, compare) }
   print(newTree)
  }*/
  /*
    7
   / \
  2  10
   */

  def print[T](tree: Tree[T],  level: Int = 1): Unit = {
    val prefix = Seq.fill(level)('-').mkString
    tree match {
      case Tree.Branch(left, value, right) =>
        println(s"$prefix $value")
        print(left, level + 1)
        print(right, level + 1)
      case Tree.Leaf(value) =>
        println(s"$prefix $value")
      case Tree.Stump =>
        println(s"$prefix X")
    }
  }

  def add[T](tree: Tree[T], t: T, compare: (T, T) => Int): Tree[T] =
    tree match {
      case Tree.Branch(left, value, right) if compare(t, value) < 0 =>
        val newLeft = add(left, t, compare)
        Branch(newLeft, value, right)
      case Tree.Branch(left, value, right) if compare(t, value) > 0 =>
        val newRight = add(right, t, compare)
        Branch(left, value, newRight)
      case branch@Tree.Branch(_, _, _) =>
        branch
      case Tree.Leaf(value) if compare(t, value) < 0 =>
        Tree.Branch(Tree.Leaf(t), value, Tree.Stump)
      case Tree.Leaf(value) if compare(t, value) > 0 =>
        Tree.Branch(Tree.Stump, value, Tree.Leaf(t))
      case leaf@Tree.Leaf(_) =>
        leaf
      case Tree.Stump => Leaf(t)
    }

  //def add[T](tree: Tree[T], values: Seq[T], compare: (T, T) => Int): Tree[T] =

  // def create[T](values: Seq[T], compare: (T, T) => Int): Tree[T] =
}
