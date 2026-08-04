package lab.basic;

public class Lab06MethodPractice {
    public static void main(String[] args) {
        /*
         * 练习目标：方法定义、参数、返回值。
         *
         * TODO:
         * 1. 实现 add 方法，返回两个 int 的和。
         * 2. 实现 isAdult 方法，判断年龄是否大于等于 18。
         * 3. 实现 getLevel 方法，根据分数返回 "A"、"B"、"C"、"D"。
         * 4. 在 main 方法里调用这些方法，并输出结果。
         */

        int sum = add(1, 2);
        System.out.println(sum);

        boolean flag = isAdult(19);
        System.out.println(flag);

        String levelStr = getLevel(88);
        System.out.println(levelStr);
    }

    static int add(int a, int b) {
        return a + b;
    }

    static boolean isAdult(int age) {
        return age >= 18;
    }

    static String getLevel(int score) {
        if (score >= 90) return "A";
        if (score >= 80) return "B";
        if (score >= 60) return "C";
        return "D";
    }
}

