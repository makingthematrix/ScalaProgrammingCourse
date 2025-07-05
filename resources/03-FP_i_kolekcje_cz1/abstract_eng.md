# Introduction to Functional Programming

Should this be after the lecture on Scala Collections? Or should these two lectures be combined?

### Lecture Plan

* Functions as Data
  * What is a function (def and val forms)
  * Anonymous functions
  * Passing functions as parameters
  * Partial and total functions
  * Returning and composing functions (generators, currying)
* Type System
  * Higher-Kinded Types using Seq as an example
  * Option as an alternative to nullability
* Example from "Many Happy Early Returns"
  * Imperative version
  * Discussion of code common to all versions
  * Naive FP version using find and map
  * FP version using partial functions - collectFirst
  * FP version using collectFirst + unapply
  * Complex imperative version
  * Complex FP version
  * Refactoring the FP example using Higher-Kinded Types