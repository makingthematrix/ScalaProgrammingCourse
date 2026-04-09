import munit.FunSuite

class MUnitVersionSuite extends FunSuite {

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

    // run
    val app = new MUnitVersion(
      read         = () => inputLines,
      askForUpdate = () => { asked += 1; 2 },
      write        = outputLines => { writeCalls += 1; written = Some(outputLines) }
    )
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

  test("run handles empty input by writing empty list") {
    var written: Option[List[String]] = None

    new MUnitVersion(
      read         = () => Nil,
      askForUpdate = () => 5,
      write        = out => { written = Some(out) }
    ).run()

    assertEquals(written, Some(Nil))
  }

  test("run supports negative and zero increments") {
    val inputLines = List(
      "Aragorn,Son of Arathorn,87",
      "Frodo,Baggins,50"
    )

    // Zero increment
    var zeroOut: Option[List[String]] = None
    val appZero = new MUnitVersion(
      read         = () => inputLines,
      askForUpdate = () => 0,
      write        = out => zeroOut = Some(out)
    )
    appZero.run()
    assertEquals(zeroOut, Some(inputLines))

    // Negative increment
    var negOut: Option[List[String]] = None
    val appNeg = new MUnitVersion(
      read         = () => inputLines,
      askForUpdate = () => -2,
      write        = out => negOut = Some(out)
    )
    appNeg.run()
    val expectedNeg = List(
      "Aragorn,Son of Arathorn,85",
      "Frodo,Baggins,48"
    )
    assertEquals(negOut, Some(expectedNeg))
  }
}
