package leetcode

fun main() {
//    val nums = intArrayOf(4,3,2,7,8,2,3,1)
    val nums = intArrayOf(1,1)
    val result = FindAllNumbersDisappearedInAnArray().findDisappearedNumbers(nums)
    println("result: $result")
}
class FindAllNumbersDisappearedInAnArray {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val arrSize = nums.size
        val numsList = nums.toSet().sorted()
        println("numsList")
        numsList.forEach {
            print("$it ")
        }

        val targetList = mutableListOf<Int>()
        for (i in 0 until arrSize) {
            targetList.add(i + 1)
        }
        println()
        println("targetList")
        targetList.forEach {
            print("$it ")
        }


        val resultList = targetList - numsList
        println()
        println("resultList")
        resultList.forEach {
            print("$it ")
        }

        return resultList
    }
}