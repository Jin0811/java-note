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

        /*
         * ========== 标准答案 ==========
         *
         * 实际输出：
         * true
         * root
         *
         * 问题 1：url、用户名、密码。
         *
         * 问题 2：使用 MySQL JDBC 协议，连接本机 3306 端口的 java_note 数据库。
         *
         * 问题 3：因为本地可能没有安装 MySQL 或驱动。
         *     先学习标准 API 和代码结构，比一上来卡在环境问题更稳。
         */
    }
}
