package hashMap;

import java.util.Random;
import list.List;

public class Main {

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        List<String> list = new List<>();

        for (int i = 0; i < 1_000_000; i++) {
            hashMap.add("" + i, "" + i);
            list.add("" + i);
        }

        List<String> elements = new List<>();
        Random randomizer = new Random();
        for (int i = 0; i < 1000; i++) {
            elements.add("" + randomizer.nextInt(200000));
        }

        long startingTimeList = System.nanoTime();
        for (int i = 0; i < elements.size(); i++) {
            list.contains(elements.get(i));
        }
        long endingTimeList = System.nanoTime();

        long startingTimeHashMap = System.nanoTime();
        for (int i = 0; i < elements.size(); i++) {
            hashMap.get(elements.get(i));
        }
        long endingTimeHashMap = System.nanoTime();

        long listMili = (endingTimeList - startingTimeList) / 1_000_000;
        long hashMapMili = (endingTimeHashMap - startingTimeHashMap) / 1_000_000;

        System.out.println("List searching time: " + listMili + " miliseconds");
        System.out.println("HashMap searching time: " + hashMapMili + " miliseconds");
    }

}
