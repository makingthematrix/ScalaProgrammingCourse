package org.fpinscala

// 9

object CollectionView {
  private val numbers: Seq[Int] = 1 to 100

  // eager collection
  val firstEvenSquareGreaterThan100_NoView: Int =
    numbers
      .map(n => {
        println(s"Square of $n being calculated.")
        n * n
      })
      .filter(n => n > 100 && n % 2 == 0)
      .head
  
  // Using view
  val firstEvenSquareGreaterThan100_View: Int =
    numbers
      .view
      .map(n => {
        println(s"Square of $n being calculated.")
        n * n
      })
      .filter(n => n > 100 && n % 2 == 0)
      .head

/*  @main def main(): Unit = {
    println(firstEvenSquareGreaterThan100_NoView)
    println(firstEvenSquareGreaterThan100_View)
  }*/

}
