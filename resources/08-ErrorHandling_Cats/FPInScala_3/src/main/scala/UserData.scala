package org.fpinscala

import java.nio.file.{Path, Paths}
import scala.jdk.CollectionConverters.*

type UserId = Int

case class UserData(id: UserId, name: String, email: String, age: Int){
  def toLine: String = s"$id,$name,$email,$age"
}

object UserData {
  val database: Seq[UserData] = Seq(
    UserData(1, "John Doe", "john@@gmail.com", 56),
    UserData(2, "Jane Smith", "jane smith@yahoo.com", 9),
    UserData(3, "Michael Brown", "michaeloutlook.com", 101),
    UserData(4, "Emily Johnson", "emily at icloud.com", 17),
    UserData(5, "Daniel Wilson", "daniel@hotmail.com", 67),
    UserData(6, "Sophia Martinez", "sophia@aol.com", 42),
    UserData(7, "Christopher Taylor", "christopher@mail.com", 24),
    UserData(8, "Olivia Anderson", "olivia@live.com", 28),
    UserData(9, "James Thomas", "james@protonmail.com", 32),
    UserData(10, "Isabella Jackson", "isabella@gmail.com", 30),
    UserData(11, "Alexander White", "alexander@yahoo.com", 25)
  )
  
  def findUser(name: String): UserData = {
    database.find(_.name == name).get
  }

  val parents: Map[UserId, UserId] = Map(
    1  -> 3,
    4  -> 12, // !!!
    5  -> 3,
    6  -> 2,
    7  -> 5,
    8  -> 5,
    10 -> 1,
    11 -> 5
  )
  

  def databaseAsJava(): java.util.Collection[UserData] = database.asJavaCollection

  val FilePath: Path = Paths.get("resources/users.csv")

  def fromLine(line: String): UserData = {
    val arr = line.split(",")
    UserData(arr(0).toInt, arr(1), arr(2), arr(3).toInt)
  }
}
