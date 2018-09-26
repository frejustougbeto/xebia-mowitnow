
object Automator {
  val SEPARATOR = " "

  def initiateGrid(firstLine: String): LawnGrid = {
    val gridSpec = firstLine.split(SEPARATOR).map(_.toInt)
    LawnGrid(gridSpec(0), gridSpec(1))
  }


}

class Automator() {
  var lawnGrid: LawnGrid = _

  def runSequence(sequence: List[String]): Unit = {
    if(sequence.length < 2)
      throw new IllegalArgumentException("Automator should have at least a lawn and a mower")

    lawnGrid = Automator.initiateGrid(sequence.head)
  }
}
