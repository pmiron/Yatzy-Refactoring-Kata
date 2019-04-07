
import org.junit.*
import org.junit.Assert.*

class YatzyTest {

    @Test
    fun chanceScoresSumOfAllDiceTest() {
        assertEquals(15, Yatzy(2, 3, 4, 5, 1).chance())
        assertEquals(16, Yatzy(3, 3, 4, 5, 1).chance())
    }

    @Test
    fun yatzyTest() {
        assertEquals(50, Yatzy(4, 4, 4, 4, 4).yatzy())
        assertEquals(50, Yatzy(6, 6, 6, 6, 6).yatzy())
        assertEquals(0, Yatzy(6, 6, 6, 6, 3).yatzy())
    }

    @Test
    fun onesTest() {
        assertEquals(1, Yatzy(1, 2, 3, 4, 5).ones())
        assertEquals(2, Yatzy(1, 2, 1, 4, 5).ones())
        assertEquals(0, Yatzy(6, 2, 2, 4, 5).ones())
        assertEquals(4, Yatzy(1, 2, 1, 1, 1).ones())
    }

    @Test
    fun twosTest() {
        assertEquals(4, Yatzy(1, 2, 3, 2, 6).twos())
        assertEquals(10, Yatzy(2, 2, 2, 2, 2).twos())
    }

    @Test
    fun threesTest() {
        assertEquals(6, Yatzy(1, 2, 3, 2, 3).threes())
        assertEquals(12, Yatzy(2, 3, 3, 3, 3).threes())
    }

    @Test
    fun foursTest() {
        assertEquals(12, Yatzy(4, 4, 4, 5, 5).fours())
        assertEquals(8, Yatzy(4, 4, 5, 5, 5).fours())
        assertEquals(4, Yatzy(4, 5, 5, 5, 5).fours())
    }

    @Test
    fun fivesTest() {
        assertEquals(10, Yatzy(4, 4, 4, 5, 5).fives())
        assertEquals(15, Yatzy(4, 4, 5, 5, 5).fives())
        assertEquals(20, Yatzy(4, 5, 5, 5, 5).fives())
    }

    @Test
    fun sixesTest() {
        assertEquals(0, Yatzy(4, 4, 4, 5, 5).sixes())
        assertEquals(6, Yatzy(4, 4, 6, 5, 5).sixes())
        assertEquals(18, Yatzy(6, 5, 6, 6, 5).sixes())
    }

    @Test
    fun pairTest() {
        assertEquals(6, Yatzy(3, 4, 3, 5, 6).pair())
        assertEquals(10, Yatzy(5, 3, 3, 3, 5).pair())
        assertEquals(12, Yatzy(5, 3, 6, 6, 5).pair())
    }

    @Test
    fun twoPairTest() {
        assertEquals(16, Yatzy(3, 3, 5, 4, 5).twoPair())
        assertEquals(16, Yatzy(3, 3, 5, 5, 5).twoPair())
    }

    @Test
    fun threeOfAKindTest() {
        assertEquals(9, Yatzy(3, 3, 3, 4, 5).threeOfAKind())
        assertEquals(15, Yatzy(5, 3, 5, 4, 5).threeOfAKind())
        assertEquals(9, Yatzy(3, 3, 3, 3, 5).threeOfAKind())
    }

    @Test
    fun fourOfAKindTest() {
        assertEquals(12, Yatzy(3, 3, 3, 3, 5).fourOfAKind())
        assertEquals(20, Yatzy(5, 5, 5, 4, 5).fourOfAKind())
        assertEquals(12, Yatzy(3, 3, 3, 3, 3).fourOfAKind())
    }

    @Test
    fun smallStraightTest() {
        assertEquals(15, Yatzy(1, 2, 3, 4, 5).smallStraight())
        assertEquals(15, Yatzy(2, 3, 4, 5, 1).smallStraight())
        assertEquals(0, Yatzy(1, 2, 2, 4, 5).smallStraight())
    }

    @Test
    fun largeStraightTest() {
        assertEquals(20, Yatzy(6, 2, 3, 4, 5).largeStraight())
        assertEquals(20, Yatzy(2, 3, 4, 5, 6).largeStraight())
        assertEquals(0, Yatzy(1, 2, 2, 4, 5).largeStraight())
    }

    @Test
    fun fullHouseTest() {
        assertEquals(18, Yatzy(6, 2, 2, 2, 6).fullHouse())
        assertEquals(0, Yatzy(2, 3, 4, 5, 6).fullHouse())
    }
}
