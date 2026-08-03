package generic;

public class GenericMethodDemo {
    public static void main(String[] args) {
        String name = first("Alex", "Ben");
        Integer score = first(90, 100);

        System.out.println("name = " + name);
        System.out.println("score = " + score);

        printPair("Java", 100);
    }

    static <T> T first(T a, T b) {
        return a;
    }

    static <K, V> void printPair(K key, V value) {
        System.out.println(key + " -> " + value);
    }
}

