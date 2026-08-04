package lab.basic;

public class Lab03IfElsePractice {
    public static void main(String[] args) {
        /*
         * 练习目标：if / else if / else 条件判断。
         *
         * TODO:
         * 1. 定义一个 int 变量 score，表示考试分数。
         * 2. 如果 score >= 90，输出 "优秀"。
         * 3. 如果 score >= 80，输出 "良好"。
         * 4. 如果 score >= 60，输出 "及格"。
         * 5. 其他情况输出 "需要继续练习"。
         * 6. 再用三元表达式输出 score 是否通过。
         */

        int score = 68;

        if (score >= 90) {
            System.out.println("优秀");
        } else if (score >= 80) {
            System.out.println("良好");
        } else if (score >= 60) {
            System.out.println("及格");
        } else {
            System.out.println("需要继续练习");
        }

        System.out.println(score >= 60 ? "通过" : "未通过");
    }
}

