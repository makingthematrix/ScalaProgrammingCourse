package org.fpinscala.finished

// 4

import org.fpinscala.Color
import Color.*
import scala.util.Random

object FunctionsReturningFunctions {
  case class Cat(name: String, color: Color)

  val colors = Color.values.toSeq
  val catNames = Seq("Fluff", "Shadow", "Garfield")

  def catGenerator(name: String): () => Cat = {
    val color = colors(Random.nextInt(colors.size))
    () => Cat(name, color)
  }

  def catGenerator(color: Color): () => Cat = {
    val name = catNames(Random.nextInt(catNames.size))
    () => Cat(name, color)
  }

  val gen1 = catGenerator("Fluff")
  val gen2 = catGenerator(Black)

  // partial application
  def createBlackCat = Cat.apply(_, Color.Black)

  /*
  Currying is the process of converting a function with multiple arguments into a sequence
  of functions that take one argument. Each function returns another function that consumes
  the following argument.

  Partial application is the process of reducing the number of arguments by applying some
  of them when the method or function is created.

  More: https://www.baeldung.com/scala/currying
   */
  def sum(x: Int, y: Int): Int = x + y
  def sum2(x: Int)(y: Int): Int = x + y
  val sum3: Int => Int => Int = { x => y => x + y }
  val increment: Int => Int = sum2(1)(_)

/*  @main def main(): Unit = {
    //println(gen1())
    //println(gen2())
    //println(increment(3))
  }*/
}
