/*
 * Class Automator and its companion object handle
 * all interactions between the client and the mowers
 */


object Automator {
  val SEPARATOR = " "
  val MOVE = 'A'
  val RIGHT = 'D'
  val LEFT = 'G'

  /*
   * Initiate a LawnGrid object from the first line a the command file
   */
  def initiateGrid(firstLine: String): LawnGrid = {
    val gridSpec = firstLine.split(SEPARATOR).map(_.toInt)
    LawnGrid(gridSpec(0) + 1, gridSpec(1) + 1)
  }

  /*
   * Order the movement of the mower from a initial position and the sequence of command
   */
  def runMower(initialPosition: String, commands: String, lawnGrid: LawnGrid): String = {
    val splitted = initialPosition.split(SEPARATOR)

    val mower = new Mower(
      splitted(0).toInt,
      splitted(1).toInt,
      splitted(2),
      lawnGrid
    )

    for(command <- commands.toList) {
      command match {
        case MOVE => mower.move()
        case RIGHT => mower.turn()
        case LEFT => mower.turn(Rotation.COUNTER_CLOCKWISE)
      }

    }

    mower.stateReport
  }

}

class Automator {
  var lawnGrid: LawnGrid = _

  /*
   * Initialized the lawn and sequentially run the mowers
   */
  def runSequence(sequence: List[String]): List[String] =
    sequence match {
      case x :: xs =>
        lawnGrid = Automator.initiateGrid(x)
        if(xs.length % 2 == 1)
          throw new IllegalArgumentException("For each mower we should an initialisation and a list of command")
        xs
          .grouped(2)
          .map(l => Automator.runMower(l.head, l(1), lawnGrid))
          .toList
      case _ => throw new IllegalArgumentException("Automator should have at least a lawn and a mower")
    }
}
