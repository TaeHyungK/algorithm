package leetcode

fun main() {
//    val nums = intArrayOf(0,0,1,1,1,2,2,3,3,4)
    val nums = intArrayOf(1,1,2)
    val result = RemoveDuplicatesFromAnArray().removeDuplicates(nums)
    println("result: $result")
}

class RemoveDuplicatesFromAnArray {
    fun removeDuplicates(nums: IntArray): Int {
        val setValue = nums.toSet()
        var index = 0
        setValue.forEach {
            nums[index] = it
            index++
        }

        nums.forEach {
            println(it)
        }
        return setValue.size
    }
}