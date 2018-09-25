/*
 * Orientation enum list the four cardinal points
 *
 * It's defined in clockwise order to be able to easily rotate
 * by incrementing the id
 */
object Orientation extends Enumeration {
  type Orientation = Value
  val NORTH, EAST, WEST, SOUTH = Value
}