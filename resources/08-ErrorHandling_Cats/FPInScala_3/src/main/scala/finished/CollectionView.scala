package org.fpinscala
package finished

object CollectionView {
  private val numbers: Seq[Int] = 1 to 100

  // Without using view
  val firstEvenSquareGreaterThan100_NoView: Seq[Int] =
    numbers
      .map(n => n * n)
      .filter(n => n > 100 && n % 2 == 0)
      .take(2)
  
  // Using view
  val firstEvenSquareGreaterThan100_View: Int =
    numbers
      .view
      .map(n => {
        println(s"Square of $n being calculated.") // To observe the lazy evaluation
        n * n
      })
      .filter(n => n > 100 && n % 2 == 0)
      .head

  // using a standard, eager collection
  val eagerResult: Seq[Int] =
    numbers
      .map(n => n * n) // Squaring operation
      .filter(n => n % 2 == 0) // Filtering even numbers
      .take(5) // Taking first 5
      .toList // Forcing evaluation

  // Using view
  val viewResult: Seq[Int] =
    numbers
      .view
      .map(n => n * n) // Squaring operation
      .filter(n => n % 2 == 0) // Filtering even numbers
      .take(5) // Taking first 5
      .toList // Forcing evaluation

  println(s"View Result: $viewResult")

  // Using LazyList
  val lazyListResult: LazyList[Int] =
    numbers
      .to(LazyList)
      .map(n => n * n)
      .filter(n => n % 2 == 0)
      .take(5)
}
