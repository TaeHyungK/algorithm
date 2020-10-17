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

    // delete last position
    public void delete() {
        if (head.link == null) {
            // 리스트에 데이터가 head 하나뿐인 경우
            head = null;
        } else {
            Node temp = head.link;
            Node pre = head;
            while (temp.link != null) {
                pre = temp;
                temp = temp.link;
            }

            pre.link = null;
        }
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
