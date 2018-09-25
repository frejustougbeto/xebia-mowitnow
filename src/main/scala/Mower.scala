import Rotation._

/*
 * Mowner asset
 */
class Mower(var position: Coordinate, var direction: Orientation) {

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
}
