package stack;

import java.util.Arrays;

public class Stack {

    private int capacity;
    private int[] arr;
    private int actualIndex;

    public Stack(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        actualIndex = -1;
    }

    public void push(int element) {
        if (actualIndex == capacity - 1) {
            throw new RuntimeException("Stack is full");
        }

        arr[++actualIndex] = element;
    }

    public int pop() {
        if (actualIndex < 0) {
            throw new RuntimeException("Stack is empty");
        }

        return arr[actualIndex--];
    }

    public int peek() {
        return arr[actualIndex];
    }
}
