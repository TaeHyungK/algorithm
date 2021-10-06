package leetcode

fun main() {
//    val nums = intArrayOf(1,1,0,1,1,1)
    val nums = intArrayOf(1,0,1,1,0,1)
    val result = MaxConsecutiveOnes().findMaxConsecutiveOnes(nums)
    println("result: $result")
}

class MaxConsecutiveOnes {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var count = 0
        var max = 0
        for (i in nums.indices) {
            if (nums[i] == 1) {
                count++
            } else {
                max = max.coerceAtLeast(count)
                count = 0
            }
        }

        return max.coerceAtLeast(count)
    }
}