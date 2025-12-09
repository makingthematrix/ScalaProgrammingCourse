import java.nio.file.{Files, Path, Paths}
import scala.jdk.CollectionConverters.*
import org.slf4j.LoggerFactory

class MUnitVersion(read        : () => List[String], 
                   askForUpdate: () => Int, 
                   write       : List[String] => Unit) {
  import MUnitVersion.updateAge

  def run(): Unit = {
    val lines        = read()
    val protagonists = lines.map(Protagonist.fromLine)
    val n            = askForUpdate()
    val updated      = protagonists.map(updateAge(_, n))
    val newLines     = updated.map(_.toLine)
    write(newLines)
  }
}

object MUnitVersion {
  def main(): Unit = MUnitVersion().run()
  
  def apply(): MUnitVersion =
    new MUnitVersion(
      read         = () => read(FilePath),
      askForUpdate = askForUpdate,
      write        = write(FilePath, _)
    )

  private val FilePath: Path = Paths.get("resources/protagonists.csv")
  private val log =
    LoggerFactory.getLogger(classOf[MUnitVersion])

  private def updateAge(p: Protagonist, n: Int): Protagonist = p.copy(age = p.age + n)

  private def read(path: Path): List[String] =
    Files.readAllLines(path).asScala.toList

  private def askForUpdate(): Int = {
    printf("By how much should I update the age? ")
    val answer = scala.io.StdIn.readLine()
    answer.toInt
  }

  private def write(path: Path, lines: List[String]): Unit =
    Files.writeString(path, lines.mkString("\n"))
}
