package io.github.template

import com.badlogic.gdx.graphics.Texture
import java.nio.file.Paths

sealed trait Token:
  val pos: Position
  val texture: Texture

final case class Pawn(override val pos: Position, override val texture: Texture = Pawn.texture) extends Token
  
object Pawn:
  lazy val texture: Texture = new Texture(Paths.get("pawn.png").toString)