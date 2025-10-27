package main.scala

object ArtistFan {
  trait Music
  trait Metal extends Music
  trait PowerMetal extends Metal


  class Fan[T <: Music]

  class Artist[T <: Music]

  def main(): Unit = {
    val musicArtist: Artist[Music] = new Artist[Music]
    val powerMetalArtist: Artist[PowerMetal] = new Artist[PowerMetal]
    val musicFan: Fan[Music] = new Fan[Music]
    val powerMetalFan: Fan[PowerMetal] = new Fan[PowerMetal]
  }
}
