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

    var numbers = ArrayList<Int>()
    var i: Int = 0

    while (i < 10) {
        i = i + 1
        numbers.add(getNumber(level))
    }

    print(numbers)
}