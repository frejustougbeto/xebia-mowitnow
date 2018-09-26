/*
 * Orientation mimic a enum that lists the four cardinal points
 *
 * Each point defines its next and previous point in the compass
 * `vector` defines the coordinate of the direction vector
 * in the euclidian plan
 */

object Orientation {
  def fromName(name: String): Orientation =
    name match {
      case "N" => NORTH
      case "E" => EAST
      case "S" => SOUTH
      case "W" => WEST
      case _ => throw new IllegalArgumentException(s"Unknown name $name")
    }
}

sealed trait Orientation {
  val name: String
  val vector: Coordinate
  def next(): Orientation
  def previous(): Orientation
}

case object NORTH extends Orientation {
  override val name: String = "N"
  override def next(): Orientation = EAST
  override def previous(): Orientation = WEST
  override val vector: Coordinate = Coordinate(0, 1)
}

case object EAST extends Orientation {
  override val name: String = "E"
  override def next(): Orientation = SOUTH
  override def previous(): Orientation = NORTH
  override val vector: Coordinate = Coordinate(1, 0)
}

case object SOUTH extends Orientation {
  override val name: String = "S"
  override def next(): Orientation = WEST
  override def previous(): Orientation = EAST
  override val vector: Coordinate = Coordinate(0, -1)
}

case object WEST extends Orientation {
  override val name: String = "W"
  override def next(): Orientation = NORTH
  override def previous(): Orientation = SOUTH
  override val vector: Coordinate = Coordinate(-1, 0)
}