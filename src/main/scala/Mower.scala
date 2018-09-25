import Rotation._

/*
 * Mowner asset
 */
class Mower(var position: Coordinate, var direction: Orientation, lawnGrid: LawnGrid) {

  if(!lawnGrid.contains(position))
    throw new IllegalArgumentException("Initial position should be in lawnGrid")

  /*
   * Auxiliary constructor for commodity
   */
  def this(x: Int, y: Int, direction: Orientation, lawnGrid: LawnGrid) = this(Coordinate(x, y), direction, lawnGrid)

  /*
   * When this method is called, mowner turn in place
   * clockwise (default) or counter clockwise
   */
  def turn(rotation: Rotation = CLOCKWISE): Unit = {
    this.direction = rotation match {
      case CLOCKWISE => this.direction.next()
      case COUNTER_CLOCKWISE => this.direction.previous()
    }
  }

  /*
   * When this method is called, mowner moves of one
   * space in the current direction
   */
  def move(): Unit = {
    this.position += this.direction.vector
  }

  /*
   * Two mowers are "equals" if they are on the same squere with the same direction
   */
  override def equals(that: scala.Any): Boolean =
    that match {
      case that: Mower => this.position == that.position && this.direction == this.direction
      case _ => false
    }
}
