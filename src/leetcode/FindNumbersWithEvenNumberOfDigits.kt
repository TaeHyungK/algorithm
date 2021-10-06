package leetcode

fun main() {
    val nums = intArrayOf(12,345,2,6,7896)
//    val nums = intArrayOf(555,901,482,1771)
    val result = FindNumbersWithEvenNumberOfDigits().findNumbers(nums)
    println("result: $result")
}

class FindNumbersWithEvenNumberOfDigits {
    fun findNumbers(nums: IntArray): Int {
        var result = 0
        for (i in nums.indices) {
            val data = nums[i]
            if (data.toString().split("").size % 2 == 0) {
                result++
            }
        }

        return result
    }
}