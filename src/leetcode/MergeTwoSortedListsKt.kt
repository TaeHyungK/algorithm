package leetcode

fun main() {
    val l1 = ListNode(1)
    l1.next = ListNode(2)
    l1.next?.next = ListNode(4)

    val l2 = ListNode(1)
    l2.next = ListNode(3)
    l2.next?.next = ListNode(4)

    val result = MergeTwoSortedListsKt().mergeTwoLists(l1, l2)
    println("result: $result")
}

class MergeTwoSortedListsKt {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        when {
            l1 == null && l2 == null -> return null
            l1 == null && l2 != null -> return l2
            l1 != null && l2 == null -> return l1
        }

        val list = mutableListOf<ListNode>()

        var l1Head = l1
        while (l1Head != null) {
            list.add(l1Head)
            l1Head = l1Head.next
        }

        var l2Head = l2
        while (l2Head != null) {
            list.add(l2Head)
            l2Head = l2Head.next
        }

        if (list.isEmpty()) {
            return null
        }

        list.sortBy { it.`val` }
        val dummyNode = ListNode(-1)
        dummyNode.next = list.first()
        for (i in 1 until list.size) {
            val prevNode = list[i - 1]
            val curNode = list[i]

            prevNode.next = curNode
        }

        var logNode = dummyNode.next
        while (logNode != null) {
            println(logNode)
            logNode = logNode.next
        }

        return dummyNode.next
    }
}