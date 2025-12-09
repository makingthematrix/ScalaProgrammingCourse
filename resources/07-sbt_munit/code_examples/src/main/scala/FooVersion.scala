import java.nio.file.{Files, Path, Paths}
import scala.jdk.CollectionConverters.*


trait FooVersion {
  def read(): List[String]
  def askForUpdate(): Int
  def write(list: List[String]): Unit
}

class FooVersionImpl extends FooVersion {
  import FooVersion.FilePath
  override def read(): List[String] =
    Files.readAllLines(FilePath).asScala.toList

  override def askForUpdate(): Int = {
    printf("By how much should I update the age? ")
    val answer = scala.io.StdIn.readLine()
    answer.toInt
  }

  override def write(lines: List[String]): Unit =
    Files.writeString(FilePath, lines.mkString("\n"))
}

object FooVersion {
  given FooVersion = new FooVersionImpl

  def run(using fooVersion: FooVersion): Unit = {
    import fooVersion.*

    val lines = read()
    val protagonists = lines.map(Protagonist.fromLine)
    val n = askForUpdate()
    val updated = protagonists.map(updateAge(_, n))
    val newLines = updated.map(_.toLine)
    write(newLines)
  }

  @main def main(): Unit = {
    run
  }

  val FilePath: Path = Paths.get("resources/protagonists.csv")

  private def updateAge(p: Protagonist, n: Int): Protagonist = {
    val newAge = p.age + n
    println(s"The age of ${p.firstName} ${p.lastName} changes from ${p.age} to $newAge")
    p.copy(age = newAge)
  }
}

