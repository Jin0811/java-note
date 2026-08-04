package quiz.jdbc;

public class Quiz01JdbcConnectionQuestion {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/java_note";
        String user = "root";

        System.out.println(url.startsWith("jdbc:mysql://"));
        System.out.println(user);

        /*
         * 问题：
         * 1. JDBC 连接数据库通常需要哪三个配置？
         * 2. jdbc:mysql://localhost:3306/java_note 表示什么？
         * 3. 为什么 JDBC 示例不直接硬连数据库？
         */
    }
}
