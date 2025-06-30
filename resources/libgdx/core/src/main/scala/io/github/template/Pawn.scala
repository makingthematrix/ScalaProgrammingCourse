package io.github.template

import java.nio.file.{Paths, Path}

case class Pawn(position: Position)

object Pawn:
    val icon: Path = Paths.get("pawn.png")
