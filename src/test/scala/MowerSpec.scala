import org.scalatest.FlatSpec

class MowerSpec extends FlatSpec {
    "A Mower" should "have an initial position" in {
        val mower = new Mower(0, 0, NORTH)
        assert(mower.x == 0)
        assert(mower.y == 0)
        assert(mower.direction == NORTH)
    }
}