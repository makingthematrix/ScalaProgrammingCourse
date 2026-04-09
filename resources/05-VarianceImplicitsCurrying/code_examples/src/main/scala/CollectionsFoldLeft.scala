package org.fpinscala

// 4

object CollectionsFoldLeft {
  // Let's write FizzBuzz and use union types
  val numbers = 1 to 100

  def fizzBuzz(n: Int): Int | String =
    n match {
      case _ if n % 15 == 0 => "FizzBuzz"
      case _ if n % 3 == 0  => "Fizz"
      case _ if n % 5 == 0  => "Buzz"
      case _ => n
    }

  // Create a range of numbers from 1 to 100

  // Use foldLeft to iterate through the numbers and apply the fizzBuzz function
  val fizzBuzzList: Seq[Int | String] = numbers.foldLeft[List[Int | String]](Nil) {
    (acc, n) => acc.appended(fizzBuzz(n))
  }

 /* @main def main(): Unit = {
    val res = fizzBuzzList.collect {
      case n: Int => n.toString
    }
    println(res.mkString(", "))
  }*/
}
