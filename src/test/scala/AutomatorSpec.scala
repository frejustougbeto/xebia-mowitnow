import org.scalatest.FlatSpec

class AutomatorSpec extends FlatSpec {

  behavior of "Automator"

  it should "initiate a grid from a string" in {
    assert(LawnGrid(6, 6) == Automator.initiateGrid("5 5"))
  }

  it should "order the mower to go over the lawn with the first sequence" in {
    assert("1 3 N" == Automator.runMower("1 2 N", "GAGAGAGAA", LawnGrid(6, 6)))
  }

  it should "order the mower to go over the lawn with the second sequence" in {
    assert("5 1 E" == Automator.runMower("3 3 E", "AADAADADDA", LawnGrid(6, 6)))
  }

  it should "run a complete sequence" in {
    assert(
      List("1 3 N", "5 1 E") ==
      new Automator().runSequence(List("5 5", "1 2 N", "GAGAGAGAA", "3 3 E", "AADAADADDA"))
    )
  }
}
