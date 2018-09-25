import org.scalatest.FlatSpec

class MowerSpec extends FlatSpec {
    "A Mower" should "have an initial position" in {
        val mower = new Mower(0, 0, NORTH)
        assert(mower.x == 0)
        assert(mower.y == 0)
        assert(mower.direction == NORTH)
    }

    it should "turn clockwise" in {
      val mower = new Mower(0, 0, NORTH)
      mower.turn(Rotation.CLOCKWISE)
      assert(mower.x == 0)
      assert(mower.y == 0)
      assert(mower.direction == EAST)

      mower.turn(Rotation.CLOCKWISE)
      assert(mower.x == 0)
      assert(mower.y == 0)
      assert(mower.direction == SOUTH)

      mower.turn(Rotation.CLOCKWISE)
      assert(mower.x == 0)
      assert(mower.y == 0)
      assert(mower.direction == WEST)

      mower.turn(Rotation.CLOCKWISE)
      assert(mower.x == 0)
      assert(mower.y == 0)
      assert(mower.direction == NORTH)

    }

  it should "turn counter clockwise" in {
    val mower = new Mower(0, 0, NORTH)
    mower.turn(Rotation.COUNTER_CLOCKWISE)
    assert(mower.x == 0)
    assert(mower.y == 0)
    assert(mower.direction == WEST)

    mower.turn(Rotation.COUNTER_CLOCKWISE)
    assert(mower.x == 0)
    assert(mower.y == 0)
    assert(mower.direction == SOUTH)

    mower.turn(Rotation.COUNTER_CLOCKWISE)
    assert(mower.x == 0)
    assert(mower.y == 0)
    assert(mower.direction == EAST)

    mower.turn(Rotation.COUNTER_CLOCKWISE)
    assert(mower.x == 0)
    assert(mower.y == 0)
    assert(mower.direction == NORTH)

  }
}