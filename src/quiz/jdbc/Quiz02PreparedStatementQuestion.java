package quiz.jdbc;

public class Quiz02PreparedStatementQuestion {
    public static void main(String[] args) {
        String sql = "select * from users where name = ? and age >= ?";

        System.out.println(sql);
        System.out.println("参数下标从 1 开始");

        /*
         * 问题：
         * 1. ? 在 SQL 中表示什么？
         * 2. setString(1, name) 中的 1 表示什么？
         * 3. PreparedStatement 相比字符串拼接有什么优势？
         */

        /*
         * ========== 标准答案 ==========
         *
         * 问题 1：表示参数占位符，真正的值后续用 setXxx 填进去。
         *
         * 问题 2：表示第 1 个 ?。JDBC 参数位置从 1 开始，不是从 0 开始。
         *
         * 问题 3：SQL 模板和参数分离，代码更清晰，也能防 SQL 注入。
         */
    }
}
