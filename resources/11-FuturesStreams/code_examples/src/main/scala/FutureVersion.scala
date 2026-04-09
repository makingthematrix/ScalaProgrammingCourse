/*
1. FutureVersion with a global execution context
2. Difference between .zip, .sequence, and. for/yield
3. FutureVersion with a custom execution context
4. FutureVersion with a result
5. But what is a Future? (CustomFuture)
6. PromiseVersion
7. Event streams - slides
8. fxcalculator
 */
import java.nio.file.{Files, Path, Paths}
import scala.concurrent.Future
import scala.jdk.CollectionConverters.*

object FutureVersion {
  import scala.concurrent.ExecutionContext.Implicits.global // [1]
  //private val threadPool = Executors.newFixedThreadPool(2)
  //given ExecutionContext = ExecutionContext.fromExecutor(threadPool) //[2]

  def main(): Unit = {
    val pFuture = Future { read(FilePath).map(Protagonist.fromLine) }
    val nFuture = Future { askForUpdate() }

    val resultFuture = pFuture.zip(nFuture).map { (protagonists, n) =>
      val updated = protagonists.map(updateAge(_, n))
      val newLines = updated.map(_.toLine)
      write(FilePath, newLines)
    }

    // or: Future.sequence(pFuture, nFuture)
    /* but don't do this:
    val resultFuture = for {
      protagonists <- pFuture
      n            <- nFuture
    } yield (protagonists, n)
     */

    //Await.ready(resultFuture, 1.minute) // [1]
    //resultFuture.onComplete(_ => threadPool.shutdown()) // [2]

/*    Try(Await.result(resultFuture, 5.seconds)) match {
      case Failure(exception) => println(s"FAILURE: ${exception.getMessage}")
      case Success(_) => println(s"Program completed successfully")
    }*/ // [3]
  }

  private val FilePath: Path = Paths.get("resources/protagonists.csv")

  private def read(path: Path): List[String] =
    Files.readAllLines(path).asScala.toList

  private def askForUpdate(): Int = {
    printf("By how much should I update the age? ")
    val answer = scala.io.StdIn.readLine()
    answer.toInt
  }

  private def updateAge(p: Protagonist, n: Int): Protagonist = {
    val newAge = p.age + n
    println(s"The age of ${p.firstName} ${p.lastName} changes from ${p.age} to $newAge")
    p.copy(age = newAge)
  }

  private def write(path: Path, lines: List[String]): Unit =
    Files.writeString(path, lines.mkString("\n"))
}
