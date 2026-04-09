package org.fpinscala

// 5
object CollectionsXRay {

  // Parameter name hints
  def parameter(enabled: Boolean): Unit =
    setParameterInDB(Map("enabled" -> enabled))

  parameter(true)
  parameter(false)

  private def setParameterInDB(map: Map[String, Boolean]): Unit =
    map.foreach {
      (name, b) => println(s"$name -> $b")
    }

  // Type hints
  private val foo = 1 + 2 // Field
  Seq(1, 2, 3).map(x => x + 1)       // Lambda parameter
  Seq(1, 2, 3).map(_ + 1)            // Lambda placeholder
  private val (x, y) = (1, 2)        // Variable pattern
  val sum: Int = (foo, x, y) match { // Pattern matching
    case (a, b, c) => a + b + c
  }

  // Local and class fields type hints
  class Foo(a: Int, b: String){
    def this(a: Int) = this(a, "bar")
    private def foo(d: Int) = a + d + 1
    override def toString: String = b
  }

  @main def main(): Unit = {
    val foo = new Foo(1, "1")
    println(foo)
  }

  // Ranges
  private val r1 = 1 to 10
  private val r2 = 1 until 10
  private val r3 = 1 to 10 by 2
  private val r4 = 10 to 1 by -2
  private val r5 = Range(1, 10, 2)

  // Method chains
  private val words = Seq("a", "sequence", "of", "words")

  words
    .view
    .map(_.length)
    .filter(_ > CollectionsXRay.sum)
    .toSeq
    .distinct
    .headOption
    .getOrElse(0)

  // Implicit parameters
  enum Numbers {
    case One, Two, Three
  }

  import Numbers.*
  given Ordering[Numbers] = (x: Numbers, y: Numbers) =>
    if (x == y) 0
    else x match {
      case One             => -1
      case Two if y == One =>  1
      case Two             => -1
      case Three           =>  1
    }

  Seq(Two, Three, One).sorted

  // By-name argument hints - show parentheses
  private def inReadAction[A](code: => A): A = code
  inReadAction(println("foo"))
}

