package others;

/**
 * 이진 Tree 구현해보기.
 */
public class BinaryTree {
    private Object data;
    private BinaryTree left;
    private BinaryTree right;

    public BinaryTree(Object data) {
        this.data = data;
        left = null;
        right = null;
    }

    public void addLeft(BinaryTree node) {
        if (left != null) left = null;
        left = node;
    }

    public void addRight(BinaryTree node) {
        if (right != null) right = null;
        right = node;
    }

    public Object getData() {
        return data;
    }

    public BinaryTree getLeft() {
        return left;
    }

    public BinaryTree getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
