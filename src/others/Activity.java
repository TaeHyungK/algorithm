package others;

public class Activity {
    public static void main(String[] args) {
        System.out.println("\n-------Binary Tree------");
        BinaryTree binaryTree = new BinaryTree(5);
        BinaryTree left = new BinaryTree(3);
        BinaryTree right = new BinaryTree(10);
        binaryTree.addLeft(left);
        binaryTree.addRight(right);
        System.out.println(binaryTree);
        System.out.println(binaryTree.getLeft());
        System.out.println(binaryTree.getRight());


        System.out.println("\n-------Stack------");
        Stack stack = new Stack();
        stack.push(10);
        System.out.println(stack.pop());
        System.out.println(stack);
        stack.peek();
        System.out.println(stack.pop());
        stack.push(20);
        System.out.println(stack.peek());
        stack.push(30);
        stack.push(40);
        System.out.println(stack);
        System.out.println(stack.search(30));

        System.out.println("\n-------Queue-------");
        Queue queue = new Queue();
        queue.offer(50);
        System.out.println(queue.poll());
        System.out.println(queue);
        queue.peek();
        System.out.println(queue.poll());
        queue.offer(60);
        System.out.println(queue.peek());
        queue.offer(70);
        queue.offer(80);
        System.out.println(queue);
        queue.remove();
        System.out.println(queue);

        System.out.println("\n-------LinkedList-------");
        LinkedList linkedList = new LinkedList();
        linkedList.insert("a");
        linkedList.insert("b");
        linkedList.insert("c");
        System.out.println(linkedList.toString());
        linkedList.delete();
        System.out.println(linkedList.toString());
        LinkedList.Node searchNode = linkedList.getNode("a");
        System.out.println(searchNode.toString());
        System.out.println(linkedList.getIndex("a"));
        System.out.println(linkedList.getNode(1));
        linkedList.insert("c");
        linkedList.insert("d");
        linkedList.insert("e");
        System.out.println(linkedList.toString());
        linkedList.delete(3);
        System.out.println(linkedList.toString());
    }
}
