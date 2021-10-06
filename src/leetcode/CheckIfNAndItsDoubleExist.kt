package leetcode

fun main() {
    val arr = intArrayOf(10,2,5,3)
//    val arr = intArrayOf(7,1,14,11)
//    val arr = intArrayOf(3,1,7,11)
//    val arr = intArrayOf(-10,12,-20,-8,15)
//    val arr = intArrayOf(-16,-13,8)
//    val arr = intArrayOf(102,-592,457,802,98,-132,883,356,-857,461,-453,522,250,476,991,540,-852,-485,-637,999,-803,-691,-880,881,-584,750,-124,745,-909,-892,304,-814,868,665,50,-40,26,-242,-797,-360,-918,-741,88,-933,-93,360,-738,833,-191,563,449,840,806,-87,-950,508,74,-448,-815,-488,639,-334)
    val result = CheckIfNAndItsDoubleExist().checkIfExist(arr)
    println("result: $result")
}

class CheckIfNAndItsDoubleExist {
    fun checkIfExist(arr: IntArray): Boolean {
        arr.sort()
        for (i in arr.indices) {
            val data = arr[i].toFloat()
            val target = if (data > 0 ) {
                data * 2
            }  else {
                data / 2
            }.toFloat()
            for (j in i+1 until arr.size) {
                if (arr[j].toFloat() == target) {
                    return true
                }
            }
        }

        return false
    }
}