package org.fpinscala.finished

// 4

object CollectionsFoldLeft {
  // fizz buzz! union types!
  def fizzBuzz(n: Int): Int | String = n match {
    case _ if n % 15 == 0 => "FizzBuzz"
    case _ if n % 3 == 0  => "Fizz"
    case _ if n % 5 == 0  => "Buzz"
    case _ => n
  }

  // Generate a range of numbers from 1 to 100
  val numbers = 1 to 100

  // Use foldLeft to iterate through the numbers and apply the fizzBuzz function
  val fizzBuzzList =
    numbers.foldLeft[List[Int | String]](Nil) {
      (acc, n) => acc.appended(fizzBuzz(n))
    }

/*  @main def main(): Unit = {
    println(fizzBuzzList)
  }*/
}
