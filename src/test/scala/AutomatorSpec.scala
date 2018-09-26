import org.scalatest.FlatSpec

class AutomatorSpec extends FlatSpec {

  behavior of "Automator"

  it should "initiate a grid from a string" in {
    assert(LawnGrid(5, 5) == Automator.initiateGrid("5 5"))
  }

}
