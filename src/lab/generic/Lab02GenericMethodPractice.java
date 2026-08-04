package lab.generic;

public class Lab02GenericMethodPractice {
    public static void main(String[] args) {
        /*
         * 练习目标：泛型方法。
         *
         * TODO:
         * 1. 实现 pickFirst 方法，返回第一个参数。
         * 2. 分别传入两个 String、两个 Integer。
         * 3. 实现 printPair 方法，接收两个不同类型的参数并输出。
         */

        String name = pickFirst("Alex", "Ben");
        Integer score = pickFirst(88, 99);

        System.out.println(name);
        System.out.println(score);

        printPair("Java", 100);
        printPair("passed", true);
    }

    static <T> T pickFirst(T a, T b) {
        return a;
    }

    static <K, V> void printPair(K key, V value) {
        System.out.println(key + " -> " + value);
    }
}
