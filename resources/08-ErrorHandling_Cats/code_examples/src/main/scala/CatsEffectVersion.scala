package org.fpinscala

import cats.effect.{IO, IOApp}
import cats.syntax.all.*

import java.nio.file.{Files, Path}
import scala.io.StdIn.readLine
import scala.jdk.CollectionConverters.*

// 13.2 writing something

object CatsEffectVersion extends IOApp.Simple {
  override def run: IO[Unit] = {
    for {
      lines   <- read(UserData.FilePath)
      users   =  lines.map(UserData.fromLine)
      n       <- askForUpdate
      updated <- users.traverse(updateAge(_, n))
      newLines = updated.map(_.toLine)
      _       <- write(UserData.FilePath, newLines)
    } yield {}
  }

  private def read(path: Path): IO[List[String]] =
    IO { Files.readAllLines(path).asScala.toList }

  private val askForUpdate: IO[Int] =
    for {
      _      <- IO.print("By how much should I update the age? ")
      answer <- IO(readLine())
    } yield answer.toInt

  private def updateAge(user: UserData, n: Int): IO[UserData] = {
    val newAge = user.age + n
    for {
      _ <- IO.println(s"The age of ${user.name} changes from ${user.age} to $newAge")
      updated = user.copy(age = newAge)
    } yield updated
  }

  private def write(path: Path, lines: List[String]): IO[Unit] =
    IO { Files.writeString(path, lines.mkString("\n")) }
}
