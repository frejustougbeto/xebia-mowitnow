import Rotation._

/*
 * Mowner asset
 */
class Mower(val x: Int, val y: Int, var direction: Orientation) {
  def turn(rotation: Rotation): Unit = {
    this.direction = rotation match {
      case CLOCKWISE => this.direction.next()
      case COUNTER_CLOCKWISE => this.direction.previous()
    }
  }
}
