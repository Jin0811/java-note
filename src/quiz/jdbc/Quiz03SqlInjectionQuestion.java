package quiz.jdbc;

public class Quiz03SqlInjectionQuestion {
    public static void main(String[] args) {
        String input = "' or '1'='1";
        String unsafeSql = "select * from users where name = '" + input + "'";

        System.out.println(unsafeSql);

        /*
         * 问题：
         * 1. 这个 unsafeSql 为什么危险？
         * 2. 正确做法是什么？
         * 3. 用户输入应该被当作 SQL 代码还是参数值？
         */
    }
}
