package leetcode

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.left?.left = TreeNode(3)
    root.left?.right = TreeNode(4)
    root.right = TreeNode(2)
    root.right?.left = TreeNode(4)
    root.right?.right = TreeNode(3)

    val result = SymmetricTreeKt().isSymmetric(root)
    println("result: $result")
}

class SymmetricTreeKt {
    var leftList = mutableListOf<Int?>()
    var rightList = mutableListOf<Int?>()

    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) {
            return false
        }

        makeLeftList(root.left)
        makeRightList(root.right)

        return leftList == rightList
    }

    private fun makeLeftList(root: TreeNode?) {
        if (root == null) {
            leftList.add(null)
            return
        }

        makeLeftList(root.right)
        makeLeftList(root.left)
        leftList.add(root.`val`)
    }

    private fun makeRightList(root: TreeNode?) {
        if (root == null) {
            rightList.add(null)
            return
        }

        makeRightList(root.left)
        makeRightList(root.right)
        rightList.add(root.`val`)
    }


}