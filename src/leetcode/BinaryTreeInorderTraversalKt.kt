package leetcode

fun main() {
    val root = TreeNode(1)
    root.right = TreeNode(2)
    root.right?.left = TreeNode(3)

    val result = BinaryTreeInorderTraversalKt().inorderTraversal(root)
    println("result: $result")
}

class BinaryTreeInorderTraversalKt {
    val result = mutableListOf<Int>()
    /**
     * in-order: left -> root -> right
     */
    fun inorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) {
            return result
        }

        inorderTraversal(root.left)
        result.add(root.`val`)
        inorderTraversal(root.right)

        return result
    }
}