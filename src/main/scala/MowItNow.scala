import scala.io.Source

object MowItNow extends App {
  val filename = args(0)
  var instructions = Source.fromFile(filename).getLines.toList
  println(new Automator().runSequence(instructions).mkString("\n"))
}
