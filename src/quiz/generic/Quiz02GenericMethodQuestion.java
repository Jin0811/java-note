package quiz.generic;

public class Quiz02GenericMethodQuestion {
    public static void main(String[] args) {
        System.out.println(first("Java", "Spring"));
        System.out.println(first(10, 20));
        printPair("score", 95);

        /*
         * 问题：
         * 1. first("Java", "Spring") 的 T 是什么？
         * 2. first(10, 20) 的 T 是什么？
         * 3. <K, V> 和 <T> 的区别是什么？
         */

        /*
         * ========== 标准答案 ==========
         *
         * 实际输出：
         * Java
         * 10
         * score -> 95
         *
         * 问题 1：T 是 String，返回值也是 String。
         *
         * 问题 2：T 是 Integer。10 和 20 会自动装箱成 Integer。
         *
         * 问题 3：<T> 表示一个类型参数，多个位置使用 T 时要求类型一致；
         *     <K, V> 表示两个独立的类型参数，key 和 value 可以是不同类型。
         */
    }

    static <T> T first(T a, T b) {
        return a;
    }

    static <K, V> void printPair(K key, V value) {
        System.out.println(key + " -> " + value);
    }
}
