package leetcode

fun main() {
    // 3 -> 2 -> 0 -> -4
    //       <---------
//    val head = ListNode(3)
//    head.next = ListNode(2)
//    head.next?.next = ListNode(0)
//    head.next?.next?.next = ListNode(-1)
//    head.next?.next?.next?.next = head.next

//    val head = ListNode(1)
//    head.next = ListNode(2)
//    head.next?.next = head.next

    val head = ListNode(1)

    val result = LinkedListCycle1().hasCycle(head)
    println("result: $result")
}

class LinkedListCycle1 {
    fun hasCycle(head: ListNode?): Boolean {
        if (head == null) {
            return false
        }

        val listNodeList = mutableListOf<ListNode>()

        var curNode = head
        while (curNode?.next != null) {
            if (listNodeList.contains(curNode)) {
                return true
            }

            listNodeList.add(curNode)
            curNode = curNode.next
        }

        return false
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}