package others;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    private final List<Object> list;

    /** initialize your data structure here. */
    public Stack() {
        list = new ArrayList<>();
    }

    public void push(Object object) {
        list.add(object);
    }

    public Object pop() {
        if (isEmpty()) {
            return null;
        }

        Object obj = peek();
        list.remove(list.size() - 1);
        return obj;
    }

    public Object peek() {
        if (isEmpty()) {
            return null;
        }

        return list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return "Stack{" +
                "list=" + list +
                '}';
    }
}
