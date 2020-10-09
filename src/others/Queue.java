package others;

import java.util.ArrayList;
import java.util.List;

public class Queue {
    private final List<Object> list;

    public Queue() {
        list = new ArrayList<>();
    }

    public void offer(Object obj) {
        list.add(obj);
    }

    public Object poll() {
        if (isEmpty()) {
            return null;
        }

        Object obj = peek();
        list.remove(0);
        return obj;
    }

    public Object peek() {
        if (isEmpty()) {
            return null;
        }

        return list.get(0);
    }

    public void remove() {
        if (isEmpty()) {
            System.out.println("Can not remove item. Because Queue is empty");
            return;
        }

        list.remove(0);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return "Queue{" +
                "list=" + list +
                '}';
    }
}
