package org.fpinscala

import java.nio.file.{Files, Path}
import scala.io.StdIn.readLine
import scala.jdk.CollectionConverters.*

// 13.1

object SideEffectsVersion {
   def main(): Unit = {
    val lines    = read(UserData.FilePath)
    val users    = lines.map(UserData.fromLine)
    val n        = askForUpdate()
    val updated  = users.map(updateAge(_, n))
    val newLines = updated.map(_.toLine)
    write(UserData.FilePath, newLines)
  }

  private def read(path: Path): List[String] =
    Files.readAllLines(path).asScala.toList

  private def askForUpdate(): Int = {
    printf("By how much should I update the age? ")
    val answer = readLine()
    answer.toInt
  }

  private def updateAge(user: UserData, n: Int): UserData = {
    val newAge = user.age + n
    println(s"The age of ${user.name} changes from ${user.age} to $newAge")
    user.copy(age = newAge)
  }

  private def write(path: Path, lines: List[String]): Unit =
    Files.writeString(path, lines.mkString("\n"))
}
