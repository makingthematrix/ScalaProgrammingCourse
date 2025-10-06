package org.fpinscala.finished

import scala.annotation.tailrec
import scala.util.control.TailCalls.*

object Recursion {
  def factorial(n: Int): BigInt =
    if (n <= 0) 1
    else n * factorial(n - 1)

  /*
  ```scala
  factorial(3)
  3 * factorial(2)
  3 * 2 * factorial(1)
  3 * 2 * 1 * factorial(0)
  3 * 2 * 1 * 1
  3 * 2 * 1
  3 * 2
  6
  ```
   */

  def tailFactorial(n: Int): BigInt = {
    @tailrec
    def go(n: Int, accumulator: BigInt): BigInt =
      if (n <= 0) accumulator
      else go(n - 1, n * accumulator)

    go(n, 1)
  }

  def trampolineFactorial(n: Int): BigInt = {
    def go(i: Int): TailRec[BigInt] =
      if (i <= 0) done(1)
      else tailcall(go(i - 1)).map(_ * i)

    go(n).result
  }

  // 1 -> 1, 2 -> 1, 3 -> 2, 4 -> 3, 5 -> 5, 6 -> 8

  def fibonacci(n: Int): BigInt =
    if (n == 1) 1
    else if (n == 2) 1
    else fibonacci(n - 2) + fibonacci(n - 1)

  def tailFibonacci(n: Int): BigInt = {
    @tailrec
    def go(currentN: Int, currentSum: BigInt, previousSum: BigInt): BigInt = {
      if (currentN < 1) 1
      else if (currentN == 1) previousSum
      else go(currentN - 1, currentSum + previousSum, currentSum)
    }

    go(n, 1, 1)
  }

  def trampolineFibonacci(n: Int): BigInt = {
    def go(i: Int): TailRec[BigInt] = i match {
      case 1 => done(1)
      case 2 => done(1)
      case _ =>
        for {
          a <- tailcall(go(i - 1))
          b <- tailcall(go(i - 2))
        } yield a + b
    }

    go(n).result
  }

  private val fib: LazyList[BigInt] =
    BigInt(1) #::
      BigInt(1) #::
      fib.zip(fib.tail).map { case (a, b) => a + b }

  def fibonacciLazyList(n: Int): BigInt = fib.take(n).last

/*  @main def main(): Unit = {
    //val res = factorial(10000)
    //val res = tailFactorial(10000)
    //val res = trampolineFactorial(10000)
    //val res = fibonacci(43)
    //val res = tailFibonacci(43)
    //val res = trampolineFibonacci(43)
    //val res = fibonacciLazyList(43)
    println(res)
  }*/
}
