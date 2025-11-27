import java.nio.file.Path
import com.github.tototoshi.csv.*

object LazyScalaCSVVersion {
  private val FilePath = Path.of("resources/protagonists.csv")

  private lazy val protagonists =
    CSVReader.open(FilePath.toFile)
      .all()
      .map(Protagonist.fromList)

  def main(): Unit = {
    val n = askForUpdate()
    if (n > 0) {
      val updated = protagonists.map(updateAge(_, n))
      write(FilePath, updated)
    }
  }
  
  private def askForUpdate(): Int = {
    printf("By how much should I update the age? ")
    val answer = scala.io.StdIn.readLine()
    answer.toInt
  }
  
  private def updateAge(p: Protagonist, n: Int): Protagonist = p.copy(age = p.age + n)
  
  private def write(path: Path, updated: List[Protagonist]): Unit =
    CSVWriter.open(FilePath.toFile).writeAll(updated.map(_.toList))
}
