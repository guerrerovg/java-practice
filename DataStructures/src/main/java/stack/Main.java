package stack;

public class Main {

    public static void main(String[] args) {
        StackList<String> stack = new StackList<>();

        for (int i = 0; i < 100; i++) {
            stack.push("" + i);
        }

        System.out.println(stack);

        for (int i = 0; i < 2000; i++) {
            System.out.println(stack.pop());
        }

        System.out.println(stack);

        System.out.println("-".repeat(20));

        Stack intStack = new Stack(100);
        //intStack.pop();
        for (int i = 0; i < 100; i++) {
            intStack.push(i);
            System.out.println("Added element: " + intStack.peek());
        }

        for (int i = 0; i < 101; i++) {
            System.out.println("Removed element: " + intStack.pop());
        }
    }
}
