package leetcode

fun main() {
    val n = 4
    val result = FibonacciNumber().fib(n)
    println("result: $result")
}

class FibonacciNumber {
    fun fib(n: Int): Int {
        return when (n) {
            0 -> 0
            1 -> 1
            else -> {
                fib(n - 1) + fib(n - 2)
            }
        }
    }
}