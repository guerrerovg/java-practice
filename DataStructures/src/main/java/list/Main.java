package list;

public class Main {

    public static void main(String[] args) {
        List<String> list = new List<>();

        for (int i = 0; i < 100; i++) {
            list.add(i + "");
        }

        list.remove("50");

        System.out.println(list.contains("50"));

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
