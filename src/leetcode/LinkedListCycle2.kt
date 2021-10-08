package leetcode

fun main() {
    // 3 -> 2 -> 0 -> -4
    //       <---------
//    val head = ListNode(3)
//    head.next = ListNode(2)
//    head.next?.next = ListNode(0)
//    head.next?.next?.next = ListNode(-1)
//    head.next?.next?.next?.next = head.next

    val head = ListNode(1)
    head.next = ListNode(2)
    head.next?.next = head.next

//    val head = ListNode(1)

    val result = LinkedListCycle2().detectCycle(head)
    println("result: $result")
}

class LinkedListCycle2 {
    fun detectCycle(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }

        val listNodeList = mutableListOf<ListNode>()

        var curNode = head
        while (curNode?.next != null) {
            if (listNodeList.contains(curNode)) {
                return curNode
            }

            listNodeList.add(curNode)
            curNode = curNode.next
        }

        return null
    }
}