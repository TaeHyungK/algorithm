package others;

public class LinkedList {
    private Node head;

    public LinkedList() {
        head = null;
    }

    public LinkedList(Node head) {
        this.head = head;
    }

    // insert last position
    public void insert(Object data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.link != null) {
                // 마지막 위치를 찾음
                temp = temp.link;
            }
            temp.link = newNode;
        }
    }

    // insert specific position
    public void insert(int position, Object data) {
        Node newNode = new Node(data);
        Node preNode = getNode(position - 1);

        newNode.link = preNode.link;
        preNode.link = newNode;
    }

    // delete last position
    public void delete() {
        if (head.link == null) {
            // 리스트에 데이터가 head 하나뿐인 경우
            head = null;
        } else {
            Node pre = head;
            while (pre.link.link != null) {
                pre = pre.link;
            }

            pre.link = null;
        }
    }

    // delete specific position
    public void delete(int position) {
        if (position == 0) {
            Node temp = head;
            Node next = head.link;

            temp.link = null;
            head = next;
            return;
        }

        Node preNode = getNode(position - 1);
        Node curNode = preNode.link; // getNode(position)
        Node nextNode = curNode.link; // getNode(position + 1)

        preNode.link = nextNode;
        curNode = null;
    }

    public Node getNode(Object data) {
        Node temp = head;

        while (temp != null) {
            if (data.hashCode() == temp.getData().hashCode()) {
                return temp;
            } else {
                temp = temp.link;
            }
        }

        return temp;
    }

    public Node getNode(int index) {
        Node temp = head;

        int i = 0;
        while (temp != null) {
            if (i == index) {
                return temp;
            }
            temp = temp.link;
            i++;
        }

        return head;
    }

    public int getIndex(Object data) {
        int index = 0;
        Node temp = head;

        while (temp != null) {
            if (data.hashCode() == temp.getData().hashCode()) {
                return index;
            } else {
                temp = temp.link;
            }
            index++;
        }

        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Node temp = head;
        while (temp != null) {
            sb.append(temp.getData().toString()).append(" ");
            temp = temp.link;
        }

        return "LinkedList{ " +
                sb.toString() +
                '}';
    }

    public class Node{
        private Object data;
        public Node link;

        public Node() {
            this.data = null;
            this.link = null;
        }

        public Node(Object data) {
            this.data = data;
            this.link = null;
        }

        public Node(Object data, Node link) {
            this.data = data;
            this.link = link;
        }

        public Object getData() {
            return this.data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", link=" + link +
                    '}';
        }
    }
}
