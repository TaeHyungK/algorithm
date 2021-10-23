package leetcode

fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next?.next = ListNode(3)
    head.next?.next?.next = ListNode(4)

    val result = SwapNodesInPairs().swapPairs(head)
    println("result: $result")
}

class SwapNodesInPairs {
    fun swapPairs(head: ListNode?): ListNode? {
        val dummyNode = ListNode(-1)
        dummyNode.next = head

        var currentNode: ListNode? = dummyNode
        while (currentNode?.next != null && currentNode.next?.next != null) {
            val first = currentNode.next
            val second = currentNode.next?.next

            first?.next = second?.next
            second?.next = first
            currentNode.next = second

            currentNode = currentNode.next?.next
        }

        currentNode = dummyNode.next
        while (currentNode != null) {
            println(currentNode.`val`)
            currentNode = currentNode.next
        }


        return dummyNode.next
    }
}