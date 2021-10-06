package leetcode

import kotlin.math.pow

fun main() {
//    val nums = intArrayOf(-4,-1,0,3,10)
    val nums = intArrayOf(-7,-3,2,3,11)
    val result = SquresOfASortedArray().sortedSquares(nums)
    println("result: $result")
}

class SquresOfASortedArray {
    fun sortedSquares(nums: IntArray): IntArray {
        for (i in nums.indices) {
            nums[i] = nums[i].toDouble().pow(2).toInt()
        }
        nums.sort()

        nums.forEach {
            println(it)
        }

        return intArrayOf()
    }
}