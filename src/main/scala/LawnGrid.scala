/*
 * Represents the lawn to be mown
 */
case class LawnGrid(width: Int, height: Int) {

  /*
   * Check if a coordinate is part of the lawn
   */
  def contains(p: Coordinate): Boolean = p.x >= 0 && p.x < width && p.y >= 0 && p.y < height
}
