/**
 * Provides a random number
 * 
 * @param Int level Level of randomness. Major number is more difficult
 */
fun getNumber(level: Int): Int {
    if (level == 1) {
        return (1..10).random()
    } else if (level == 2) {
        return (1..100).random()
    } else if (level == 3) {
        return (1..1000).random()
    }
    throw IllegalArgumentException("Invalid level")
}

fun main() {
    var level:Int

    while (true) {
        print("Please insert 1 for the level easy, 2 to normal level and 3 to hard level: ")        
        level = readLine()!!.toInt()
        if (level in 1..3) {
            break
        }
    }

    var numbers = arrayListOf(getNumber(level), getNumber(level), getNumber(level))
    var sum: Int = 0
    var number: Int = 0
    var userSum: Int
    var rightAnswers: Int = 0

    while (true) {
        number = getNumber(level)
        numbers.add(number)
        sum = 0

        numbers.forEachIndexed { index, number ->
            print(number)

            if (index != numbers.size - 1) {
                print(" + ")
            } else {
                print(" = ")
            }

            sum += number
        }

        userSum = readLine()!!.toInt()

        if (sum != userSum) {
            println("Wrong answer! The right sum is $sum. Game over.")
            println("Right answers: " + rightAnswers)
            return
        }

        rightAnswers += 1
    }
}