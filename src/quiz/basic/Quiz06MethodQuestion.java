package quiz.basic;

public class Quiz06MethodQuestion {
    public static void main(String[] args) {
        /*
         * 题目 6：先判断每个方法调用的返回结果，再运行验证。
         */
        System.out.println(add(10, 20));
        System.out.println(isPassed(59));
        System.out.println(isPassed(60));
        System.out.println(buildMessage("Alex", "Java"));

        /*
         * 问题：
         * 1. add 方法的返回值类型是什么？
         * 2. isPassed 方法为什么适合返回 boolean？
         * 3. buildMessage 方法中的参数顺序能随便换吗？
         */
    }

    static int add(int a, int b) {
        return a + b;
    }

    static boolean isPassed(int score) {
        return score >= 60;
    }

    static String buildMessage(String name, String skill) {
        return name + " is learning " + skill;
    }
}

