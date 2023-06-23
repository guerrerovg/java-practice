package stack;

import java.util.ArrayList;
import java.util.List;

public class StackList<T>{

    private List<T> stack;

    public StackList() {
        stack = new ArrayList<>();
    }

    public void push(T element) {
        stack.add(element);
    }

    public T pop() {
        if (stack.size() == 0) {
            return null;
        }

        return stack.remove(stack.size() - 1);
    }

    @Override
    public String toString() {
        if (stack.size() == 0) {
            return "[]";
        } else if (stack.size() == 1) {
            return "[ " + stack.get(0) + " ]";
        }

        String output = "[" + stack.get(0);
        for (int i = 1; i < stack.size(); i++) {
            output += ", " + stack.get(i);
        }

        return output +"]";
    }
}
