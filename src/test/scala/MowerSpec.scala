import org.scalatest.{FlatSpec, Matchers}

class MowerSpec extends FlatSpec with Matchers {

  behavior of "Mower"

  it should "be able to be initiate by two means" in {
    val lawn = LawnGrid(5, 5)
    val mower1 = new Mower(Coordinate(0, 0), NORTH, lawn)
    val mower2 = new Mower(0, 0, NORTH, lawn)
    assert(mower1 == mower2)
  }

  it should "not be instanciate outside the lawn" in {
    val lawn = LawnGrid(5, 5)
    an[IllegalArgumentException] should be thrownBy new Mower(Coordinate(6, 6), NORTH, lawn)
    an[IllegalArgumentException] should be thrownBy new Mower(Coordinate(4, 6), NORTH, lawn)
    an[IllegalArgumentException] should be thrownBy new Mower(Coordinate(-1, -1), NORTH, lawn)
  }

  it should "turn clockwise" in {
    val lawn = LawnGrid(5, 5)
    val mower = new Mower(Coordinate(0, 0), NORTH, lawn)

    mower.turn(Rotation.CLOCKWISE)
    assert(mower == new Mower(0, 0, EAST, lawn))

    mower.turn(Rotation.CLOCKWISE)
    assert(mower == new Mower(0, 0, SOUTH, lawn))

    mower.turn(Rotation.CLOCKWISE)
    assert(mower == new Mower(0, 0, WEST, lawn))

    mower.turn(Rotation.CLOCKWISE)
    assert(mower == new Mower(0, 0, NORTH, lawn))
  }

  it should "turn counter clockwise" in {
    val lawn = LawnGrid(5, 5)
    val mower = new Mower(Coordinate(0, 0), NORTH, lawn)

    mower.turn(Rotation.COUNTER_CLOCKWISE)
    assert(mower == new Mower(0, 0, WEST, lawn))

    mower.turn(Rotation.COUNTER_CLOCKWISE)
    assert(mower == new Mower(0, 0, SOUTH, lawn))

    mower.turn(Rotation.COUNTER_CLOCKWISE)
    assert(mower == new Mower(0, 0, EAST, lawn))

    mower.turn(Rotation.COUNTER_CLOCKWISE)
    assert(mower == new Mower(0, 0, NORTH, lawn))

  }

  it should "moves when asked to" in  {
    val lawn = LawnGrid(5, 5)
    val mower = new Mower(Coordinate(0, 0), NORTH, lawn)

    mower.move()
    assert(mower == new Mower(0, 1, NORTH, lawn))

    mower.turn()
    mower.move()
    assert(mower == new Mower(1, 1, EAST, lawn))

    mower.turn()
    mower.move()
    assert(mower == new Mower(1, 0, SOUTH, lawn))

    mower.turn()
    mower.move()
    assert(mower == new Mower(0, 0, WEST, lawn))
  }

  it should "not move outside the lawn" in {
    val lawn = LawnGrid(5, 5)
    val mower = new Mower(Coordinate(0, 0), SOUTH, lawn)
    mower.move()

    assert(mower.position == Coordinate(0, 0))
  }
}