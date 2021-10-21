package leetcode

fun main() {
    val root = TreeNode(1)
    root.right = TreeNode(2)
    root.right?.left = TreeNode(3)

    val result = BinaryTreePreorderTraversal().preorderTraversal(root)
    println("result: $result")
}

class BinaryTreePreorderTraversal {
    val result = mutableListOf<Int>()
    /**
     * pre-order: root -> left -> right
     */
    fun preorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) {
            return result
        }

        result.add(root.`val`)
        preorderTraversal(root.left)
        preorderTraversal(root.right)

        return result
    }

}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}