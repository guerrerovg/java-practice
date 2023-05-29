package bogosort;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Creates and fill the array with random numbers
        int[] arr = new int[10];
        Random rnd = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(100);
        }

        // Var to check the iterations that make the cycle before the array is sorted
        int iterations = 0;

        System.out.println("Starting array: " + Arrays.toString(arr));

        long starting = System.nanoTime();

        while (!isArrayInOrder(arr)) {
            System.out.println(Arrays.toString(arr));
            shuffle(arr);
            iterations++;
        }

        long ending = System.nanoTime();

        long timeElapsed = (ending - starting) / 1000000000;

        System.out.println("Ending array: " + Arrays.toString(arr));
        System.out.println("Time: " + timeElapsed + " seconds");
        System.out.println("Iterations: " + iterations);

    }

    // Checks if the array is in order
    public static boolean isArrayInOrder(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }

        return true;
    }

    // Randomize using the fisher-yates (durstenfeld?) algorithm
    public static void shuffle(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            int rndIndex = new Random().nextInt(arr.length);

            int aux = arr[i];
            arr[i] = arr[rndIndex];
            arr[rndIndex] = aux;
        }
    }
}