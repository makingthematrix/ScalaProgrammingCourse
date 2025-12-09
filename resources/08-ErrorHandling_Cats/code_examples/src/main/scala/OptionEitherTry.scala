package org.fpinscala

import cats.Foldable.ops.toAllFoldableOps
import org.fpinscala.UserData.databaseAsJava

import scala.io.StdIn.readLine
import scala.util.{Failure, Success, Try}

// 12

object OptionEitherTry {
  import UserData.{database, parents}

  object WithExceptions {
    def findParent(name: String): UserData = {
      val user = UserData.findUser(name)
      val parentId = parents(user.id)
      database.find(_.id == parentId).get
    }
  }

  object WithTry {
    def findParent(name: String): Try[UserData] = {
      Try(UserData.findUser(name))
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

  sealed trait MyOption[T] {
    def flatMap[X](f: T => MyOption[X]): MyOption[X]
  }

  case class MySome[T](value: T) extends MyOption[T] {
    override def flatMap[X](f: T => MyOption[X]): MyOption[X] = f(value)
  }

  case object MyNone extends MyOption[Nothing]{
    override def flatMap[X](f: Nothing => MyOption[X]): MyOption[X] = MyNone.asInstanceOf[MyOption[X]]
  }

  object MyOption {
    def apply[T](value: T): MyOption[T] =
      if (value != null) MySome(value)
      else MyNone.asInstanceOf[MyOption[T]]
  }

  def findOrNull(name: String): UserData =
    database.find(_.name == name) match {
      case Some(value) => value
      case None => null
    }

  def findOrNull(userId: UserId): UserData =
    database.find(_.id == userId) match {
      case Some(value) => value
      case None => null
    }

  def parentOrNull(userId: UserId): UserId =
    parents.get(userId) match {
      case Some(value) => value
      case None => null.asInstanceOf[UserId]
    }

  def main(): Unit = {
    val numbers = Seq(1, 2, 3)
    val chars = Seq('a', 'b', 'c')

    val newSeq = for {
      n <- numbers
      c <- chars
    } yield s"$n$c"

    //println(res)
    /*val name = read()
    val parent = WithEither.findParent(name)
    parent match {
      case Left(value) => println(s"Error: $value")
      case Right(value) => println(value)
    }*/
      //println(parent.name)
    //} catch {
    //  case exception: Exception => println(exception.getMessage)
    //}
  }

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
