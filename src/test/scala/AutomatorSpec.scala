import org.scalatest.FlatSpec

class AutomatorSpec extends FlatSpec {

  behavior of "Automator"

  it should "initiate a grid from a string" in {
    assert(LawnGrid(5, 5) == Automator.initiateGrid("5 5"))
  }

  it should "order the mower to go over the lawn" in {
    assert("1 3 N" == Automator.runMower("1 2 N", "GAGAGAGAA", LawnGrid(5, 5)))
  }
}
