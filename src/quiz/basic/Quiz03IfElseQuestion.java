package quiz.basic;

public class Quiz03IfElseQuestion {
    public static void main(String[] args) {
        /*
         * 题目 3：修改 score 的值，观察不同分支如何执行。
         */
        int score = 80;

        if (score > 80) {
            System.out.println("A");
        } else if (score >= 80) {
            System.out.println("B");
        } else if (score >= 60) {
            System.out.println("C");
        } else {
            System.out.println("D");
        }

        /*
         * 问题：
         * 1. score = 80 时输出什么？
         * 2. 如果第一个条件改成 score >= 80，输出会变化吗？
         * 3. if / else if 的判断顺序重要吗？
         */
    }
}

