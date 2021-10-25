package leetcode

fun main() {
    val x = 1.0
    val n = -2147483648

    val result = PowXN().myPowOther(x, n)
    println("result: $result")
}

class PowXN {
    /**
     * 음..? 잘 이해가 안간다 ㅎ..
     */
    fun myPowOther(x: Double, n: Int): Double {
        when (n) {
            0 -> return 1.0
            1 -> return x
        }

        val half = myPowOther(x, n / 2)
        return when {
            n % 2 == 0 -> {
                half * half
            }
            n > 0 -> {
                half * half * x
            }
            else -> {
                half * half / x
            }
        }
    }

    /**
     * 그냥 단순히 곱하기만 하면 StackOverflow 가 발생하게 된다.
     * 흠... 어떻게 해야되는거지..
     */
    fun myPow(x: Double, n: Int): Double {
        when (n) {
            0 -> return 0.0
            1 -> return x
        }

        return myPow(x, n, 0, 1.0)
    }

    private fun myPow(x: Double, n: Int, count: Int, acc: Double): Double {
        if (n == count) {
            return acc
        }

        return if (n > 0) {
            myPow(x, n, count + 1, acc * x)
        } else {
            myPow(x, n, count - 1, acc / x)
        }
    }
}