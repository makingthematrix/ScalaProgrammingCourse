package org.fpinscala.finished

import org.fpinscala.{UserData, UserService}

import scala.io.StdIn.readLine

// 12

object OptionEitherTry {
  import UserData.{database, parents}

  object WithExceptions {
    def findParent(name: String): UserData = {
      val user = UserService.findUser(name) // Java
      val parentId = parents(user.id)
      database.find(_.id == parentId).get
    }
  }

  object WithOption {
    def findParent(name: String): Option[UserData] =
      database
        .find(_.name == name)
        .flatMap(user => parents.get(user.id))
        .flatMap(parentId => database.find(_.id == parentId))

    def findParent2(name: String): Option[UserData] =
      for {
        user     <- database.find(_.name == name)
        parentId <- parents.get(user.id)
        parent   <- database.find(_.id == parentId)
      } yield parent
  }

  object WithEither {
    def findParent(name: String): Either[String, UserData] =
      database
        .find(_.name == name).toRight(s"No user $name in the database")
        .flatMap(user => parents.get(user.id).toRight(s"No parent found for user $name"))
        .flatMap(parentId => database.find(_.id == parentId).toRight(s"No parent with id $parentId found in the database"))

    def findParent2(name: String): Either[String, UserData] =
      for {
        user     <- database.find(_.name == name).toRight(s"No user $name in the database")
        parentId <- parents.get(user.id).toRight(s"No parent found for user $name")
        parent   <- database.find(_.id == parentId).toRight(s"No parent with id $parentId found in the database")
      } yield parent
  }

/*  @main def main(): Unit = {
    val name = read()
    println(s"name: $name")

    // exception
    try {
      val user = WithExceptions.findParent(name)
      println(user)
    } catch {
      case ex: Throwable => println(ex.getMessage)
    }

    // Option
    WithOption.findParent(name) match {
      case Some(parent) => println(parent)
      case None         => println("Error")
    }

    // Either
    WithEither.findParent(name) match {
      case Left(error) => println(s"Error: $error")
      case Right(parent) => println(parent)
    }

    // Try
    Try(WithExceptions.findParent(name)) match {
      case Failure(exception) => println(s"Error: ${exception.getMessage}")
      case Success(parent)    => println(parent)
    }
  }*/
  
  // try out with:
  // John Doe (-> Michael Brown), Maciek (-> not in the database), Jane Smith (-> parent not in the database),
  // Emily Johnson (-> invalid parent id)

  private def read(): String = {
    printf("\n> ")
    readLine().trim
  }
}
