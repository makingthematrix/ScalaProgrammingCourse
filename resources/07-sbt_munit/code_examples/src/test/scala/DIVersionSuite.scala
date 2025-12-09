import munit.FunSuite
import java.nio.file.Path

class DIVersionSuite extends FunSuite {

  test("run increments ages by n and writes updated CSV lines") {
    // mock inputs
    val inputLines = List(
      "Ada,Lovelace,36",
      "Alan,Turing,41",
      "Grace,Hopper,85"
    )

    // tracking the program
    var asked = 0
    var written: Option[List[String]] = None
    var writeCalls = 0

    val instance = new ReadUpdateWrite {
      override def read(path: Path): List[String] = inputLines
      override def askForUpdate(): Int = { asked += 1; 2 }
      override def write(path: Path, lines: List[String]): Unit = { writeCalls += 1; written = Some(lines) }
    }
    // run
    val app = new DIVersion(instance)
    app.run()

    // assertions
    assertEquals(asked, 1, "askForUpdate should be called exactly once")
    assertEquals(writeCalls, 1, "write should be called exactly once")

    val expected = List(
      "Ada,Lovelace,38",
      "Alan,Turing,43",
      "Grace,Hopper,87"
    )
    assertEquals(written, Some(expected))
  }
}
