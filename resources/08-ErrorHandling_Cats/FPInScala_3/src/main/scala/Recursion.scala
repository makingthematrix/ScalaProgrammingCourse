package org.fpinscala

import scala.annotation.tailrec

// 10

object Recursion {

  /*
   factorial(5)
   factorial(4) * 5
   1 * 2 * 3 * 4 *5
   */
  def factorial(n: Int): BigInt =
    if (n <= 1) 1
    else n * factorial(n - 1)

  private def tailFactorial(n: Int): BigInt = {
    @tailrec
    def go(n: Int, accumulator: BigInt = 1): BigInt =
      if (n <= 1) accumulator
      else go(n - 1, n * accumulator)

    go(n)
  }

  /*
  1, 1, 2, 3, 5, 8
   */
  def fibonacci(i: Int): BigInt =
    if (i == 1) 1
    else if (i == 2) 1
    else fibonacci(i - 2) + fibonacci(i - 1)

  def tailFibonacci(n: Int): BigInt = {
    @tailrec
    def go(currentN: Int, currentSum: BigInt, previousSum: BigInt): BigInt = {
      if (currentN < 1) 1
      else if (currentN == 1) previousSum
      else go(currentN - 1, currentSum + previousSum, currentSum)
    }

    go(n, 1, 1)
  }

  import scala.util.control.TailCalls.*

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


  /*
    [1, 1, 2, 3, 5, 8, ...]
    list = [1, 1, 2, 3, 5, 8, list(a - 2) + list(a - 1)]
    -> (1,1), (1, 2) (2, 3)
   */
  private val fib: LazyList[BigInt] =
    BigInt(1) #:: BigInt(1) #:: fib.zip(fib.tail).map { case (a, b) => a + b }

  def fibonacciLazyList(n: Int): BigInt =
    fib.take(n).last

/*  @main def main(): Unit = {
    val res = fibonacciLazyList(80)
    println(res)
  }*/
}