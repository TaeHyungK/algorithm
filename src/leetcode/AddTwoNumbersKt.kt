package leetcode

fun main() {
//    val l1 = ListNode(2)
//    l1.next = ListNode(4)
//    l1.next?.next = ListNode(3)
//
//    val l2 = ListNode(5)
//    l2.next = ListNode(6)
//    l2.next?.next = ListNode(4)

    val l1 = ListNode(9)
    l1.next = ListNode(9)
    l1.next?.next = ListNode(9)
    l1.next?.next?.next = ListNode(9)
    l1.next?.next?.next?.next = ListNode(9)
    l1.next?.next?.next?.next?.next = ListNode(9)
    l1.next?.next?.next?.next?.next?.next = ListNode(9)

    val l2 = ListNode(9)
    l2.next = ListNode(9)
    l2.next?.next = ListNode(9)
    l2.next?.next?.next = ListNode(9)

    val result = AddTwoNumbersKt().addTwoNumbers(l1, l2)
    println("result: $result")
}

class AddTwoNumbersKt {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var l1Node = l1
        var l2Node = l2
        val resultNode: ListNode? = ListNode(-1)
        var dummyNode = resultNode
        var isUpper = false
        while (l1Node != null || l2Node != null) {
            val l1Value = l1Node?.`val` ?: 0
            val l2Value = l2Node?.`val` ?: 0
            val sum = l1Value + l2Value + if (isUpper) 1 else 0
            isUpper = sum >= 10

            dummyNode?.next = ListNode(if (isUpper) {
                sum - 10
            } else {
                sum
            })
            dummyNode = dummyNode?.next

            l1Node = l1Node?.next
            l2Node = l2Node?.next
        }

        if (isUpper) {
            dummyNode?.next = ListNode(1)
        }

        var logHead = resultNode?.next
        while (logHead != null) {
            println(logHead)
            logHead = logHead.next
        }

        return resultNode?.next
    }
}