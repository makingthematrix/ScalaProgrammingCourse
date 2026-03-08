final case class Point(x: Int, y: Int) {
  def +(p: Point): Point = Point(x + p.x, y + p.y)
  inline infix def add(p: Point): Point = this.+(p)
}

object Point {
  def apply(z: Int): Point = new Point(z, z)

  def unapply(p: Point): (Int, Int) = (p.x, p.y)
}

trait HasCenterPoint {
  def centerPoint: Point
}

case class Triangle(a: Point, b: Point, c: Point) extends HasCenterPoint {
  override def centerPoint: Point = Triangle.centerPoint(this)
}

case class Quadrangle(a: Point, b: Point, c: Point, d: Point) extends HasCenterPoint {
  override def centerPoint: Point = {
    val seq: Seq[Point] = Seq(a, b, c, d)
    val pFinal = seq.reduce {
      (p1, p2) => p1 + p2
    }
    Point(pFinal.x / seq.size, pFinal.y / seq.size)
  }
}

object Triangle {
  //def centerPoint(t: Triangle): Point = Point((t.a.x + t.b.x + t.c.x) / 3, (t.a.y + t.b.y + t.c.y) / 3)

  val centerPoint: Triangle => Point = (t: Triangle) => Point((t.a.x + t.b.x + t.c.x) / 3, (t.a.y + t.b.y + t.c.y) / 3)
}

def distanceBetweenCenterPoints(a: HasCenterPoint, b: HasCenterPoint): Double =
  Math.sqrt(Math.pow(a.centerPoint.x - b.centerPoint.x, 2) + Math.pow(a.centerPoint.y - b.centerPoint.y, 2))


@main def main(): Unit = {
  val p = Point(1, 2)
  val q = p.copy(x = 3)
  val r = p add q

  val Point(rx, ry) = r

  val triangle = Triangle(Point(10,10), Point(11,8), Point(7,11))
  val quadrangle = Quadrangle(Point(10,10), Point(11,8), Point(7,11), Point(12,12))

  val distance = distanceBetweenCenterPoints(triangle, quadrangle)
  println(distance)

  val center = triangle.centerPoint
  println(center)

  /*
  triangle match {
    case Triangle(Point(ax, ay), Point(bx, by), Point(cx, cy)) if ax == bx =>
      println(s"Triangle with vertices: ($ax, $ay), ($bx, $by), ($cx, $cy)")
  }
  */
/*  r match {
    case Point(1,2) => println("Matched point with specific coordinates")
    case r if r == p => println("Matched point with same instance")
    case Point(rx, 4) => println(s"Matched point: ($rx, $ry)")
    case _ => println("No match found")
  }*/

/*  println(s"$rx, $ry")
  println(s"p = $p, q = $q, r = $r")
  println(p == q)*/
}