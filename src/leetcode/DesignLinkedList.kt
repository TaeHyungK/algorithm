package leetcode

fun main() {
    val myLinkedList = DesignLinkedList()
    myLinkedList.addAtHead(1)
    println(myLinkedList.toString())
    myLinkedList.addAtTail(3)
    println(myLinkedList.toString())
    myLinkedList.addAtIndex(1, 2) // linked list becomes 1->2->3
    println(myLinkedList.toString())

    println(myLinkedList.get(1)) // return 2

    myLinkedList.deleteAtIndex(1) // now the linked list is 1->3
    println(myLinkedList.toString())

    println(myLinkedList.get(1)) // return 3
}

class DesignLinkedList {
    val list = mutableListOf<Int>()

    fun get(index: Int): Int {
        if (index > list.size - 1) {
            return -1
        }

        return list[index]
    }

    fun addAtHead(`val`: Int) {
        addAtIndex(0, `val`)
    }

    fun addAtTail(`val`: Int) {
        addAtIndex(list.size, `val`)
    }

    fun addAtIndex(index: Int, `val`: Int) {
        list.add(index, `val`)
    }

    fun deleteAtIndex(index: Int) {
        if (index < 0 || index >= list.size) {
            return
        }
        list.removeAt(index)
    }

    override fun toString(): String {
        var result = ""
        list.forEach {
            result += "$it "
        }
        return result
    }

    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * var obj = MyLinkedList()
     * var param_1 = obj.get(index)
     * obj.addAtHead(`val`)
     * obj.addAtTail(`val`)
     * obj.addAtIndex(index,`val`)
     * obj.deleteAtIndex(index)
     */
}