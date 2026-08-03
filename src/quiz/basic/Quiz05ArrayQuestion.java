package quiz.basic;

public class Quiz05ArrayQuestion {
    public static void main(String[] args) {
        /*
         * 题目 5：阅读数组代码，回答问题。
         */
        String[] names = {"Alex", "Ben", "Cindy"};

        System.out.println(names.length);
        System.out.println(names[0]);
        System.out.println(names[names.length - 1]);

        /*
         * 问题：
         * 1. names.length 的值是多少？
         * 2. names[0] 输出什么？
         * 3. names[names.length - 1] 为什么能拿到最后一个元素？
         * 4. 如果访问 names[3]，会发生什么？
         */
    }
}

