import org.scalatest.FlatSpec

class MowerSpec extends FlatSpec {
    "A Mower" should "be able to be initiate by two means" in {
        val mower1 = new Mower(Coordinate(0, 0), NORTH)
        val mower2 = new Mower(0, 0, NORTH)
        assert(mower1 == mower2)
    }

    it should "turn clockwise" in {
      val mower = new Mower(Coordinate(0, 0), NORTH)

      mower.turn(Rotation.CLOCKWISE)
      assert(mower == new Mower(0, 0, EAST))

      mower.turn(Rotation.CLOCKWISE)
      assert(mower == new Mower(0, 0, SOUTH))

      mower.turn(Rotation.CLOCKWISE)
      assert(mower == new Mower(0, 0, WEST))

      mower.turn(Rotation.CLOCKWISE)
      assert(mower == new Mower(0, 0, NORTH))
    }

  it should "turn counter clockwise" in {
    val mower = new Mower(Coordinate(0, 0), NORTH)
    mower.turn(Rotation.COUNTER_CLOCKWISE)
    assert(mower == new Mower(0, 0, WEST))

    mower.turn(Rotation.COUNTER_CLOCKWISE)
    assert(mower == new Mower(0, 0, SOUTH))

    mower.turn(Rotation.COUNTER_CLOCKWISE)
    assert(mower == new Mower(0, 0, EAST))

    mower.turn(Rotation.COUNTER_CLOCKWISE)
    assert(mower == new Mower(0, 0, NORTH))

  }

  it should "moves when asked to" in  {
    val mower = new Mower(Coordinate(0, 0), NORTH)

    mower.move()
    assert(mower == new Mower(0, 1, NORTH))

    mower.turn()
    mower.move()
    assert(mower == new Mower(1, 1, EAST))

    mower.turn()
    mower.move()
    assert(mower == new Mower(1, 0, SOUTH))

    mower.turn()
    mower.move()
    assert(mower == new Mower(0, 0, WEST))
  }
}