class Yatzy(dice1: Int, dice2: Int, dice3: Int, dice4: Int, dice5: Int) {

    protected var dice: IntArray = IntArray(5)

    init {
        dice[0] = dice1
        dice[1] = dice2
        dice[2] = dice3
        dice[3] = dice4
        dice[4] = dice5
    }

    fun chance(): Int {
        return dice.sum()
    }

    fun yatzy(): Int {
        val first = dice[0]
        when(dice.all { it == first }){
            true -> return 50
            false -> return 0
        }
    }

    fun ones(): Int {
        return dice.filter{it == 1}.sum()
    }

    fun twos(): Int {
        return dice.filter{it == 2}.sum()
    }

    fun threes(): Int {
        return dice.filter{it == 3}.sum()
    }

    fun fours(): Int {
        return dice.filter{it == 4}.sum()
    }

    fun fives(): Int {
        return dice.filter{it == 5}.sum()
    }

    fun sixes(): Int {
        return dice.filter{it == 6}.sum()
    }

    data class Result(val max: Int, val list: List<Int>)

    fun pair(): Int {
        val (max, _) = pairHelper(dice.toList())
        return max + max
    }

    fun twoPair(): Int {
        val (firstMax, list) = pairHelper(dice.toList())
        val (secondMax, _) = pairHelper(list)
        return firstMax + firstMax + secondMax + secondMax
    }

    private fun pairHelper(diceValues: List<Int>): Result {
        if(diceValues.isEmpty())
            return Result(0, diceValues)
        val maxDie = diceValues.max()
        val maxDieFirstIndex = diceValues.indexOfFirst { it == maxDie }
        val maxDieLastIndex = diceValues.indexOfLast { it == maxDie }

        if(maxDieFirstIndex != maxDieLastIndex) {
            return Result(maxDie!!, diceValues.minusElement(maxDie).minusElement(maxDie))
        }
        return pairHelper(diceValues.minusElement(maxDie!!))
    }

    fun threeOfAKind(): Int {
        val t = IntArray(6)
        t[dice[0] - 1]++
        t[dice[1] - 1]++
        t[dice[2] - 1]++
        t[dice[3] - 1]++
        t[dice[4] - 1]++
        for (i in 0..5)
            if (t[i] >= 3)
                return (i + 1) * 3
        return 0
    }

    fun fourOfAKind(): Int {
        val tallies = IntArray(6)
        tallies[dice[0] - 1]++
        tallies[dice[1] - 1]++
        tallies[dice[2] - 1]++
        tallies[dice[3] - 1]++
        tallies[dice[4] - 1]++
        for (i in 0..5)
            if (tallies[i] >= 4)
                return (i + 1) * 4
        return 0
    }

    fun smallStraight(): Int {
        val tallies = IntArray(6)
        tallies[dice[0] - 1] += 1
        tallies[dice[1] - 1] += 1
        tallies[dice[2] - 1] += 1
        tallies[dice[3] - 1] += 1
        tallies[dice[4] - 1] += 1
        return if (tallies[0] == 1 &&
            tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1
        ) 15 else 0
    }

    fun largeStraight(): Int {
        val tallies = IntArray(6)
        tallies[dice[0] - 1] += 1
        tallies[dice[1] - 1] += 1
        tallies[dice[2] - 1] += 1
        tallies[dice[3] - 1] += 1
        tallies[dice[4] - 1] += 1
        return if (tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1
            && tallies[5] == 1
        ) 20 else 0
    }


    fun fullHouse(): Int {
        val tallies: IntArray
        var _2 = false
        var i: Int
        var _2_at = 0
        var _3 = false
        var _3_at = 0

        tallies = IntArray(6)
        tallies[dice[0] - 1] += 1
        tallies[dice[1] - 1] += 1
        tallies[dice[2] - 1] += 1
        tallies[dice[3] - 1] += 1
        tallies[dice[4] - 1] += 1

        i = 0
        while (i != 6) {
            if (tallies[i] == 2) {
                _2 = true
                _2_at = i + 1
            }
            i += 1
        }

        i = 0
        while (i != 6) {
            if (tallies[i] == 3) {
                _3 = true
                _3_at = i + 1
            }
            i += 1
        }

        return if (_2 && _3)
            _2_at * 2 + _3_at * 3
        else
            0
    }

}


