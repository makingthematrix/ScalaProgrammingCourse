package org.fpinscala

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

  val intTree: Tree[Int] = ???

  // print out the tree
  def print[T](tree: Tree[T], toString: T => String, level: Int = 0): Unit = ???

  def add[T](tree: Tree[T], t: T, compare: (T, T) => Int): Tree[T] = ???

  def add[T](tree: Tree[T], values: Seq[T], compare: (T, T) => Int): Tree[T] = ???

  def create[T](values: Seq[T], compare: (T, T) => Int): Tree[T] = ???
}
