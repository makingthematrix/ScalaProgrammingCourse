package org.fpinscala
package finished

// 5

object CollectionsXRay {

  // Type hints
  private val foo = 1 + 2            // Field
  Seq(1, 2, 3).map(x => x + 1)       // Lambda parameter
  Seq(1, 2, 3).map(_ + 1)            // Lambda placeholder
  private val (x, y) = (1, 2)        // Variable pattern
  val sum: Int = (foo, x, y) match { // Pattern matching
    case (a, b, c) => a + b + c
  }

  private val words = Seq("a", "sequence", "of", "words")

  words
    .view
    .map(_.length)
    .filter(_ > CollectionsXRay.sum)
    .toSeq
    .distinct
    .headOption
    .getOrElse(0)

  /**
   Scala supports <b>implicit conversions</b> and <b>implicit parameters</b>, which can significantly reduce boilerplate code - but it might be
   challenging to understand where values come from or how types are converted. Implicit hints show information about
   implicit arguments and implicit conversions that the data in question will undergo during compilation.
   The X-Ray mode may prove to be particularly useful in this case, letting you see implicit hints only for a moment when
   you want to make sure what they are, and then they will disappear again.
   */
  enum Numbers {
    case One, Two, Three
  }

  import Numbers.*
  given Ordering[Numbers] = (x: Numbers, y: Numbers) =>
    if x == y then 0 else x match {
      case One => -1
      case Two if y == One => 1
      case Two => -1
      case Three => 1
    }

  Seq(Two, Three, One).sorted

  // By-name argument hints
  private def inReadAction[A](code: => A): A = code
  inReadAction(println("foo"))

  // Parameter name hints
  def parameter(enabled: Boolean): Unit =
    setParameterInDB(Map(("enabled", enabled)))

  parameter(true)
  parameter(false)

  private def setParameterInDB(map: Map[String, Boolean]): Unit =
    map.foreach {
      (name, b) => println(s"$name -> $b")
    }
}

