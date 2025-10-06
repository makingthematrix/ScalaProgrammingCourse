package org.fpinscala.finished


// 6

object PartialFunctions {
  // Using the collect method, create a set of names of parents of our users

  import org.fpinscala.UserData.parents
  import org.fpinscala.UserData.database

  val parentNames: Seq[String] =
    database
      .map(u => parents.get(u.id))
      .collect {
        case Some(id) if database.exists(_.id == id) => database(id).name
      }

  import org.fpinscala.Animal.animals
  import org.fpinscala.Cat
  import org.fpinscala.Color.Black

  // Using the collect method, create a sequence of animals containing only black cats
  val blackCats: Seq[Cat] = animals.collect {
    case cat: Cat if cat.color == Black => cat
  }

  // We will come back to `collect` in the part about early returns
}
