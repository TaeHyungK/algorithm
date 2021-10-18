package leetcode

fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next?.next = ListNode(3)
    head.next?.next?.next = ListNode(4)
    head.next?.next?.next?.next = ListNode(5)
    val k = 2

//    val head = ListNode(0)
//    head.next = ListNode(1)
//    head.next?.next = ListNode(2)
//    val k = 4

    val result = RotateList().rotateRight(head, k)
    println("result: $result")
}

class RotateList {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head?.next == null || k == 0) {
            return head
        }

        var size = 0
        var current = head
        while (current != null) {
            current = current.next
            size++
        }
        println("size: $size")

        if (k % size == 0) {
            return head
        }

        // 순환 node로 만들어줌.
        current = head
        for (i in 0 until size) {
            if (i == size - 1) {
                current?.next = head
            }
            current = current?.next
        }

        current = head
        // k번째 노드의 앞 노드를 찾음.
        val preKIndex = size - (k % size) - 1
        for (i in 0 until preKIndex) {
            current = current?.next
        }
        println("current: $current")
        val preKNode = current
        val resultHead = preKNode?.next
        preKNode?.next = null

        current = resultHead
        while (current != null) {
            println(current)
            current = current.next
        }

        return resultHead
    }
}