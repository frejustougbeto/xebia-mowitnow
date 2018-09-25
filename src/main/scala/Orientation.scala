/*
 * Orientation mimic a enum that lists the four cardinal points
 *
 * Each point defines its next and previous point in the compass
 */

sealed trait Orientation {
  val name: String
  def next(): Orientation
  def previous(): Orientation
}

case object NORTH extends Orientation {
  override val name: String = "N"
  override def next(): Orientation = EAST
  override def previous(): Orientation = WEST
}

case object EAST extends Orientation {
  override val name: String = "E"
  override def next(): Orientation = SOUTH
  override def previous(): Orientation = NORTH
}

case object SOUTH extends Orientation {
  override val name: String = "S"
  override def next(): Orientation = WEST
  override def previous(): Orientation = EAST
}

case object WEST extends Orientation {
  override val name: String = "W"
  override def next(): Orientation = NORTH
  override def previous(): Orientation = SOUTH
}