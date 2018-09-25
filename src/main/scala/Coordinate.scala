/*
 * Represent the coordinate of square on the lawn grid
 */
case class Coordinate(x: Int, y: Int) {
  def + (other: Coordinate) = Coordinate(x + other.x, y + other.y)
}
