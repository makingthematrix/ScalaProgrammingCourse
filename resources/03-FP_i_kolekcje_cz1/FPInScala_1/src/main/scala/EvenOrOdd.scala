package org.fpinscala

object EvenOrOdd {
  sealed trait EvenOrOdd
  case object Even extends EvenOrOdd
  case object Odd extends EvenOrOdd

  def even(n: Int): EvenOrOdd = if (n %2 == 0) EvenOrOdd.Even else EvenOrOdd.Odd
}
