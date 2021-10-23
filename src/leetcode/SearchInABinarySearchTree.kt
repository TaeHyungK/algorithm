package leetcode

fun main() {
    val root = TreeNode(4)
    root.left = TreeNode(2)
    root.left?.left = TreeNode(1)
    root.left?.right = TreeNode(3)
    root.right = TreeNode(7)
    val value = 5

    val result = SearchInABinarySearchTree().searchBST(root, value)

    println("result: ${result?.`val`}")
}

class SearchInABinarySearchTree {
    /**
     * Binary Search Tree(BST, 이진 탐색 트리): root보다 작은 값은 left, 큰 값은 right에 위치한 트리
     */
    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null) {
            return null
        }

        if (root.`val` == `val`) {
            return root
        }

        var result = searchBST(root.left, `val`)
        if (result == null) {
            result = searchBST(root.right, `val`)
        }

        return result
    }
}