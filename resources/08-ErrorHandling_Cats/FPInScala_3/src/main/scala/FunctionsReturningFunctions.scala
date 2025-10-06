package org.fpinscala

// 7

object FunctionsReturningFunctions {
  val colors: Seq[Color] = Color.values.toSeq
  val catNames: Seq[String] = Seq("Fluff", "Shadow", "Garfield")

  // a cat generator for the same name and random colors
  import scala.util.Random
  def catGenerator(name: String): () => Cat = {
    () => Cat(name, colors(Random.nextInt(colors.size)))
  }

  // a cat generator for the same color and random names
  val gen1 = catGenerator("Fluff")
  val gen2 = catGenerator("Shadow")

/*
  @main def main(): Unit = {
    println(gen1())
    println(gen2())
  }
*/

  // partial application
  //def createBlackCat = Cat(_, _)


  def sum(x: Int, y: Int): Int = x + y
  def sum2(x: Int)(y: Int): Int = x + y
  val sum3: Int => Int => Int = { x => y => x + y }

  val increment: Int => Int = sum2(1)

  increment(2)


  /*
  Currying is the process of converting a function with multiple arguments into a sequence
  of functions that take one argument. Each function returns another function that consumes
  the following argument.

  Partial application is the process of reducing the number of arguments by applying some
  of them when the method or function is created.

  More:
   1. https://www.baeldung.com/scala/currying
   2. https://en.wikipedia.org/wiki/Currying
   */

}
