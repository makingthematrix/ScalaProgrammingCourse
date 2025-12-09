
import java.nio.file.{Files, Path, Paths}
import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, Future, Promise}
import scala.jdk.CollectionConverters.*
import scala.util.Try

object PromiseVersion {
  import scala.concurrent.ExecutionContext.Implicits.global

  @main def main(): Unit = {
    val nPromise = Promise[Int]()
    val pFuture = Future {
      read(FilePath).map(Protagonist.fromLine)
    }

    val resultFuture =
      pFuture
        .zip(nPromise.future)
        .map { (protagonists, n) =>
      val updated = protagonists.map(updateAge(_, n))
      val newLines = updated.map(_.toLine)
      write(FilePath, newLines)
    }

    askForUpdate(nPromise)

    Await.ready(resultFuture, 1.minute)
  }

  private val FilePath: Path = Paths.get("resources/protagonists.csv")

  private def read(path: Path): List[String] =
    Files.readAllLines(path).asScala.toList

  private def askForUpdate(nPromise: Promise[Int]): Unit = {
    printf("By how much should I update the age? ")
    val answer = scala.io.StdIn.readLine()
    nPromise.complete(Try(answer.toInt))
  }

  private def updateAge(p: Protagonist, n: Int): Protagonist = {
    val newAge = p.age + n
    println(s"The age of ${p.firstName} ${p.lastName} changes from ${p.age} to $newAge")
    p.copy(age = newAge)
  }

  private def write(path: Path, lines: List[String]): Unit =
    Files.writeString(path, lines.mkString("\n"))
}
