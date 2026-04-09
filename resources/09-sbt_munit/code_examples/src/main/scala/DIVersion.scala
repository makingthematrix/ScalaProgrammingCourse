import com.softwaremill.macwire.wire

import java.nio.file.{Files, Path, Paths}
import scala.jdk.CollectionConverters.*

trait ReadUpdateWrite {
  def read(path: Path): List[String]
  def askForUpdate(): Int
  def write(path: Path, lines: List[String]): Unit
}

class ReadUpdateWriteImpl extends ReadUpdateWrite {
  override def read(path: Path): List[String] =
    Files.readAllLines(path).asScala.toList

  override def askForUpdate(): Int = {
    printf("By how much should I update the age? ")
    val answer = scala.io.StdIn.readLine()
    answer.toInt
  }

  override def write(path: Path, lines: List[String]): Unit =
    Files.writeString(path, lines.mkString("\n"))
}

class DIVersion(instance: ReadUpdateWrite) {
  import DIVersion.{FilePath, updateAge}
  import instance.*

  def run(): Unit = {
    val lines        = read(FilePath)
    val protagonists = lines.map(Protagonist.fromLine)
    val n            = askForUpdate()
    val updated      = protagonists.map(updateAge(_, n))
    val newLines     = updated.map(_.toLine)
    write(FilePath, newLines)
  }
}

object DIVersion {
  lazy val instance: ReadUpdateWrite = wire[ReadUpdateWriteImpl]
  lazy val diVersion: DIVersion = wire[DIVersion]

  def main(): Unit = diVersion.run()

  private val FilePath: Path = Paths.get("resources/protagonists.csv")

  private def updateAge(p: Protagonist, n: Int): Protagonist = p.copy(age = p.age + n)

}
