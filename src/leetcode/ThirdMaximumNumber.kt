package leetcode

fun main() {
    val nums = intArrayOf(3,2,1)
//    val nums = intArrayOf(2,3,2,1)
//    val nums = intArrayOf(2,1)
    val result = ThirdMaximumNumber().thirdMax(nums)
    println("result: $result")
}

class ThirdMaximumNumber {
    fun thirdMax(nums: IntArray): Int {
        val numsList = nums.toSet().sorted()

        numsList.forEach {
            println(it)
        }

        return if (numsList.size >= 3) {
            numsList[numsList.size - 3]
        } else {
            numsList[numsList.size - 1]
        }
    }
}