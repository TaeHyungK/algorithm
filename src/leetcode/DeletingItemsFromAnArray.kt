package leetcode

fun main() {
//    val nums = intArrayOf(3, 2, 2, 3)
//    val `val` = 3

    val nums = intArrayOf(0,1,2,2,3,0,4,2)
    val `val` = 2
    println(DeletingItemsFromAnArray().removeElement(nums, `val`))
}

class DeletingItemsFromAnArray {
    /**
     * 모르겠어서 Solution 을 봤는데 이런 생각을 도대체 어떻게 하는거지.. 어렵다..
     *
     *          0 1 2 3
     * 1. nums=(3,2,2,3) i=0 count=0 nums[i]=3 False
     * 2. nums=(3,2,2,3) i=1 count=0 nums[i]=2 True
     * 3. nums=(2,2,2,3) i=2 count=1 nums[i]=2 False
     * 4. nums=(2,2,2,3) i=3 count=1 nums[i]=2 False
     */
    fun removeElement(nums: IntArray, `val`: Int): Int {
        // Counter for keeping track of elements other than val
        var count = 0
        // Loop through all the elements of the array
        for (i in nums.indices) {
            // If the element is not val
            if (nums[i] != `val`) {
                nums[count++] = nums[i]
            }
        }

        nums.forEach {
            println(it)
        }
        return count
    }
}