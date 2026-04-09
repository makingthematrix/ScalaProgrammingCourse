package org.fpinscala

import scala.annotation.tailrec

// 10

object Recursion {

  /*
   factorial(5)
   factorial(4) * 5
   1 * 2 * 3 * 4 *5
   */
  def factorial(n: Int): BigInt = ???

  private def tailFactorial(n: Int): BigInt =  ???

  /*
  1, 1, 2, 3, 5, 8
   */
  def fibonacci(i: Int): BigInt =
    if (i == 1 || i == 2) 1
    else fibonacci(i - 1) + fibonacci(i - 2)

 // def tailFibonacci(n: Int): BigInt = ???

//  def trampolineFibonacci(n: Int): BigInt = ???

  private val fib: LazyList[BigInt] =
    BigInt(1) #::
      BigInt(1) #::
      fib.zip(fib.tail) // LazyList((1,1), (1,2), (2, 3), (3, 5), ...
        .map { case (a, b) => a + b }

  def fibonacciLazyList(n: Int): BigInt = fib.take(n).last

  def main(): Unit = {
    val res = fibonacciLazyList(80)
    println(res)
  }
}