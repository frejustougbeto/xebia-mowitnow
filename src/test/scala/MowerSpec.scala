import org.scalatest.FlatSpec

class MowerSpec extends FlatSpec {
    "A Mower" should "have an initial position" in {
        val mower = new Mower(Coordinate(0, 0), NORTH)
        assert(mower.position == Coordinate(0, 0))
        assert(mower.direction == NORTH)
    }

    it should "turn clockwise" in {
      val mower = new Mower(Coordinate(0, 0), NORTH)
      mower.turn(Rotation.CLOCKWISE)
      assert(mower.position == Coordinate(0, 0))
      assert(mower.direction == EAST)

      mower.turn(Rotation.CLOCKWISE)
      assert(mower.position == Coordinate(0, 0))
      assert(mower.direction == SOUTH)

      mower.turn(Rotation.CLOCKWISE)
      assert(mower.position == Coordinate(0, 0))
      assert(mower.direction == WEST)

      mower.turn(Rotation.CLOCKWISE)
      assert(mower.position == Coordinate(0, 0))
      assert(mower.direction == NORTH)

    }

  it should "turn counter clockwise" in {
    val mower = new Mower(Coordinate(0, 0), NORTH)
    mower.turn(Rotation.COUNTER_CLOCKWISE)
    assert(mower.position == Coordinate(0, 0))
    assert(mower.direction == WEST)

    mower.turn(Rotation.COUNTER_CLOCKWISE)
    assert(mower.position == Coordinate(0, 0))
    assert(mower.direction == SOUTH)

    mower.turn(Rotation.COUNTER_CLOCKWISE)
    assert(mower.position == Coordinate(0, 0))
    assert(mower.direction == EAST)

    mower.turn(Rotation.COUNTER_CLOCKWISE)
    assert(mower.position == Coordinate(0, 0))
    assert(mower.direction == NORTH)

  }

  it should "moves when asked to" in  {
    val mower = new Mower(Coordinate(0, 0), NORTH)

    mower.move()
    assert(mower.position == Coordinate(0, 1))
    assert(mower.direction == NORTH)

    mower.turn()
    mower.move()
    assert(mower.position == Coordinate(1, 1))
    assert(mower.direction == EAST)

    mower.turn()
    mower.move()
    assert(mower.position == Coordinate(1, 0))
    assert(mower.direction == SOUTH)

    mower.turn()
    mower.move()
    assert(mower.position == Coordinate(0, 0))
    assert(mower.direction == WEST)
  }
}