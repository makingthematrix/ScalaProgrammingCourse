package io.github.template

import com.badlogic.gdx.graphics.Texture

import java.nio.file.{Path, Paths}

case class Pawn(position: Position, icon: Path = Pawn.icon):
  lazy val texture: Texture = new Texture(icon.toString)

object Pawn:
    val icon: Path = Paths.get("pawn.png")
