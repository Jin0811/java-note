package quiz.jdbc;

import java.sql.*;

public class Quiz01JdbcConnectionQuestion {
    public static void main(String[] args) {
        String sql = "SELECT DATABASE() as database_name, CURRENT_USER() as user_account, COUNT(*) as data_count FROM users";

        /*
         * 问题：本题需要结合本机 java_note 数据库思考。
         *
         * 1. JDBC 连接数据库通常需要哪三个配置？
         * 数据库链接地址、用户名、密码
         *
         * 2. jdbc:mysql://localhost:3306/java_note 中的协议、主机、端口和数据库分别是什么？
         * 协议：jdbc:mysql
         * 主机：localhost
         * 端口：3306
         * 数据库：java_note
         *
         * 3. 在 IDEA 中运行这条 SQL 前，需要准备 MySQL 驱动、数据源和哪些账号信息？
         * 数据库账号和密码
         *
         * 4. 请使用 JdbcConnectionDemo 的连接方式真实执行 sql，记录返回的数据库名、当前用户和行数。
         * database_name = java_note
         * user_account = root@localhost
         * data_count = 3
         *
         * 5. 如果出现 No suitable driver found，应该检查项目中的哪一项依赖？
         * MySQL Connector/J 驱动依赖
         */
        try (
            Connection connection = openConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()
        ) {
            if (resultSet.next()) {
                System.out.println("database_name = " + resultSet.getString("database_name"));
                System.out.println("user_account = " + resultSet.getString("user_account"));
                System.out.println("data_count = " + resultSet.getInt("data_count"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*
     * ========== 标准答案 ==========
     *
     * 问题 1：JDBC 连接数据库通常需要哪三个配置？
     * 答：数据库 URL、用户名和密码。
     *     MySQL 驱动依赖是运行前提，但不属于这三个连接参数。
     *
     * 问题 2：jdbc:mysql://localhost:3306/java_note 中的协议、主机、端口和数据库分别是什么？
     * 答：jdbc 是 JDBC URL 的协议前缀，mysql 是数据库子协议；
     *     localhost 是主机，3306 是 MySQL 默认端口，java_note 是数据库名。
     *     完整 URL 的结构是 jdbc:mysql://主机:端口/数据库名。
     *
     * 问题 3：在 IDEA 中运行这条 SQL 前，需要准备 MySQL 驱动、数据源和哪些账号信息？
     * 答：需要 MySQL Connector/J 驱动、数据源中的主机/端口/数据库信息，
     *     以及数据库用户名和密码。本项目默认用户名是 root，密码从
     *     JAVA_NOTE_DB_PASSWORD 环境变量读取。
     *
     * 问题 4：请使用 JdbcConnectionDemo 的连接方式真实执行 sql，记录返回的数据库名、当前用户和行数。
     * 答：当前本机数据库输出为：
     *     database_name = java_note
     *     user_account = root@localhost
     *     data_count = 3
     *     其中 data_count 是 users 表当前的记录数，数据变化后该值也会变化。
     *
     * 问题 5：如果出现 No suitable driver found，应该检查项目中的哪一项依赖？
     * 答：检查 pom.xml 中是否存在 MySQL Connector/J 依赖：
     *     com.mysql:mysql-connector-j
     *     该依赖提供 com.mysql.cj.jdbc.Driver。使用 Maven 管理依赖时，
     *     通常不需要手动调用 Class.forName()。
     */

    private static final String URL = "jdbc:mysql://localhost:3306/java_note";
    private static final String USER = "root";
    private static final String PASSWORD = System.getenv().getOrDefault("JAVA_NOTE_DB_PASSWORD", "123456");

    static Connection openConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
