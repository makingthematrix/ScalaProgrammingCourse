package io.github.template

final case class Position(x: Int, y: Int)

object Position:
  def apply(str: String): Position = new Position(str(0) - 'A', str(1) - '1')
