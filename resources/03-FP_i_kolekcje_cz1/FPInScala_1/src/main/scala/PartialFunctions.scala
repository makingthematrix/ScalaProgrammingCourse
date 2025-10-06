package org.fpinscala

// 6

object PartialFunctions {
  import org.fpinscala.UserData.*
  // Using the collect method, create a set of names of parents of our users
  val parentNames: Seq[String] =
    database
      .map(u => parents.get(u.id))
      .collect { case Some(id) if database.exists(_.id == id) => database(id).name }

  /*@main def run(): Unit = println(parentNames)*/

  // Using the collect method, create a sequence of animals containing only black cats

  // We will come back to `collect` in the part about early returns
}
