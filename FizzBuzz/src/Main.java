import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        fizzBuzz1(15);
        System.out.println("*".repeat(10));

        fizzBuzz2(15);
        System.out.println("*".repeat(10));

        fizzBuzz3(15);
    }

    public static void fizzBuzz1(int limit) {
        for (int i = 1; i <= limit; i++) {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                System.out.println("FizzBuzz");

            } else if (i % 3 == 0) {
                System.out.println("Fizz");

            } else if (i % 5 == 0) {
                System.out.println("Buzz");

            } else {
                System.out.println(i);
            }
        }
    }

    public static void fizzBuzz2(int limit) {
        for (int i = 1; i <= limit; i++) {
            String output = "";
            if (i % 3 == 0) {
                output += "Fizz";
            }

            if (i % 5 == 0) {
                output += "Buzz";
            }

            if (output.isEmpty()) {
                output = i + "";
            }

            System.out.println(output);
        }
    }

    public static void fizzBuzz3(int limit) {
        LinkedHashMap<Integer, String> pair = new LinkedHashMap<>(); // keep the insertion order
        pair.put(3, "Fizz");
        pair.put(5, "Buzz");

        for (int i = 1; i <= limit; i++) {
            String output = "";

            for (Map.Entry<Integer, String> entry : pair.entrySet()) {
                if (i % entry.getKey() == 0) {
                    output += entry.getValue();
                }
            }

            if (output.isEmpty()) {
                output = i + "";
            }

            System.out.println(output);
        }
    }
}