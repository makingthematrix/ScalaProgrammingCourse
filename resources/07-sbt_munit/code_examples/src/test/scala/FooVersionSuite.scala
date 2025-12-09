class FooVersionSuite extends munit.FunSuite{

  val inputLines = List(
    "Ada,Lovelace,36",
    "Alan,Turing,41",
    "Grace,Hopper,85"
  )

  // tracking the program
  var asked = 0
  var written: Option[List[String]] = None
  var writeCalls = 0

  given FooVersion = new FooVersion {
    override def read(): List[String] = inputLines

    override def askForUpdate(): Int = {
      asked += 1; 5
    }

    override def write(list: List[String]): Unit = {
      writeCalls += 1; written = Some(list)
    }
  }

  test("test if read, update, write give valid results") {

    FooVersion.run

    // assertions
    assertEquals(asked, 1, "askForUpdate should be called exactly once")
    assertEquals(writeCalls, 1, "write should be called exactly once")

    val expected = List(
      "Ada,Lovelace,41",
      "Alan,Turing,46",
      "Grace,Hopper,90"
    )
    assertEquals(written, Some(expected))
  }
}
