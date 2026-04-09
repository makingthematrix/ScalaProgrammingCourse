package main.scala.finished

object ArtistFan {
  trait Music
  trait Metal extends Music
  trait PowerMetal extends Metal

  // covariance
  class Fan[T <: Music]{
    def listenToMusicFrom[S <: T](artist: Artist[S]): Unit = ???
  }

  // contravariance
  class Artist[T <: Music] {
    def makeMusicFor[S >: T <: Music](fan: Fan[S]): Unit = ???
  }

  def main(): Unit = {
    val musicArtist: Artist[Music] = new Artist[Music]
    val powerMetalArtist: Artist[PowerMetal] = new Artist[PowerMetal]
    val musicFan: Fan[Music] = new Fan[Music]
    val powerMetalFan: Fan[PowerMetal] = new Fan[PowerMetal]

    // covariance

    musicFan.listenToMusicFrom(musicArtist)
    musicFan.listenToMusicFrom(powerMetalArtist)
    //powerMetalFan.listenToMusicFrom(musicArtist) // won't compile
    powerMetalFan.listenToMusicFrom(powerMetalArtist)

    // contravariance

    musicArtist.makeMusicFor(musicFan)
    //musicArtist.makeMusicFor(powerMetalFan) // won't compile
    powerMetalArtist.makeMusicFor(musicFan)
    powerMetalArtist.makeMusicFor(powerMetalFan)
  }
}
