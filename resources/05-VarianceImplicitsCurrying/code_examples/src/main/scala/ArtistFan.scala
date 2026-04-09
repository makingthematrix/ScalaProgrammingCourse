package main.scala

object ArtistFan {
  trait Music
  trait Metal extends Music
  trait PowerMetal extends Metal


  class Fan[T <: Music] {
    def listenToMusicFrom(artist: Artist[T]): Unit = ???
  }

  class Artist[T <: Music] {
    def produceMusicFor(fan: Fan[T]): Unit = ???
  }

  @main def main(): Unit = {
    val musicArtist: Artist[Music] = new Artist[Music]
    val powerMetalArtist: Artist[PowerMetal] = new Artist[PowerMetal]
    val musicFan: Fan[Music] = new Fan[Music]
    val powerMetalFan: Fan[PowerMetal] = new Fan[PowerMetal]
  }
}
