import java.nio.file.{Files, Path, Paths}
import scala.jdk.CollectionConverters.*

object SideEffectsVersion {
  def main(): Unit = {
    val lines = read(FilePath)
    val protagonists = lines.map(Protagonist.fromLine)
    val n = askForUpdate()
    val updated = protagonists.map(updateAge(_, n))
    val newLines = updated.map(_.toLine)
    write(FilePath, newLines)
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
