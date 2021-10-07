package leetcode

fun main() {
    val nums = intArrayOf(3,1,2,4)
    val result = SortArrayByParity().sortArrayByParity(nums)
    println("result: $result")
}

class SortArrayByParity {
    fun sortArrayByParity(nums: IntArray): IntArray {
        var right = nums.size - 1
        var left = 0
        while (left < right) {
            when {
                nums[left] % 2 != 0 && nums[right] % 2 == 0 -> {
                    // 홀 | 짝인 경우 -> 위치 교체
                    val temp = nums[left]
                    nums[left] = nums[right]
                    nums[right] = temp

                    left++
                    right--
                }
                nums[left] % 2 == 0 && nums[right] % 2 != 0 -> {
                    // 짝 | 홀인 경우 -> 그대로 유지하고 다음으로 넘어감.
                    left++
                    right--
                }
                nums[left] % 2 != 0 -> {
                    // 홀 | 홀인 경우 -> right만 감소함.
                    right--
                }
                nums[right] % 2 == 0 -> {
                    // 짝 | 짝인 경우 -> left만 증가함.
                    left++
                }
            }
        }

        nums.forEach {
            println(it)
        }

        return nums
    }
}