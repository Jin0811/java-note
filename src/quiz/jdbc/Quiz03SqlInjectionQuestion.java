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

        /*
         * ========== 标准答案 ==========
         *
         * 实际输出：
         * select * from users where name = '' or '1'='1'
         *
         * 问题 1：用户输入改变了 SQL 条件语义，可能导致查询出不该查的数据。
         *
         * 问题 2：使用 PreparedStatement：where name = ?，
         *     再用 setString(1, input) 传入参数。
         *
         * 问题 3：应该当作参数值，不应该直接拼成 SQL 代码。
         */
    }
}
