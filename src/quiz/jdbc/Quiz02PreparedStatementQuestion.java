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
    }
}
