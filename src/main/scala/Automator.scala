
object Automator {
  val SEPARATOR = " "
  val MOVE = 'A'
  val RIGHT = 'D'
  val LEFT = 'G'

  def initiateGrid(firstLine: String): LawnGrid = {
    val gridSpec = firstLine.split(SEPARATOR).map(_.toInt)
    LawnGrid(gridSpec(0) + 1, gridSpec(1) + 1)
  }

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
