/*
 * Orientation enum list the four cardinal points
 *
 * It's defined in clockwise order to be able to easily rotate
 * by incrementing the id
 */

sealed trait Orientation {
  val name: String
  def next()
  def previous()
}

case object NORTH extends Orientation {
  override val name: String = "N"
  override def next(): Unit = EAST
  override def previous(): Unit = WEST
}

case object EAST extends Orientation {
  override val name: String = "E"
  override def next(): Unit = SOUTH
  override def previous(): Unit = NORTH
}

case object SOUTH extends Orientation {
  override val name: String = "S"
  override def next(): Unit = WEST
  override def previous(): Unit = EAST
}

case object WEST extends Orientation {
  override val name: String = "W"
  override def next(): Unit = NORTH
  override def previous(): Unit = SOUTH
}