package org.fpinscala

import scala.io.StdIn.readLine
import scala.util.{Failure, Success, Try}

// 12

object OptionEitherTry {
  import UserData.{database, parents}

  object WithExceptions {
    def findParent(name: String): UserData = {
      val user = UserService.findUser(name)
      val parentId = parents(user.id)
      database.find(_.id == parentId).get
    }
  }

  object WithTry {
    def findParent(name: String): Try[UserData] = {
      Try(UserService.findUser(name))
        .flatMap(user => Try(parents(user.id)))
        .flatMap(parentId => Try(database.find(_.id == parentId).get))
    }
  }

  object WithOption {
    def findParent(name: String): Option[UserData] =
      database
        .find(_.name == name)
        .flatMap(user => parents.get(user.id))
        .flatMap(parentId => database.find(_.id == parentId))

    // flatMap

    def findParent2(name: String): Option[UserData] = ???
  }

  enum Error{
    case NoUser(name: String)
    case NoParent(name: String)
    case NoParentWithId(id: Int)
  }

  object WithEither {
    def findParent(name: String): Either[Error, UserData] =
      database
        .find(_.name == name).toRight(Error.NoUser(name))
        .flatMap(user => parents.get(user.id).toRight(Error.NoParent(name)))
        .flatMap(parentId => database.find(_.id == parentId).toRight(Error.NoParentWithId(parentId)))

    def findParent2(name: String): Either[String, UserData] = ??? //flatMap
  }

/*
  @main def main(): Unit = {
    val name = read()
    val parent = WithTry.findParent(name)
    parent match {
      case Failure(exception) => println(exception.getMessage)
      case Success(parent) => println(parent.name)
    }
*/



    // exception

    // Option


    // Either

    // Try (wrap the exception)

  
  // try out with:
  // John Doe (-> Michael Brown),
  // Maciek (-> not in the database),
  // Jane Smith (-> parent not in the database),
  // Emily Johnson (-> invalid parent id)

  private def read(): String = {
    printf("\n> ")
    readLine().trim
  }
}
