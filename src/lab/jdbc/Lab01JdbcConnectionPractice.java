package lab.jdbc;

import java.sql.*;

public class Lab01JdbcConnectionPractice {
    private static final String URL = "jdbc:mysql://localhost:3306/java_note";
    private static final String USER = "root";
    private static final String PASSWORD = System.getenv().getOrDefault("JAVA_NOTE_DB_PASSWORD", "123456");

    public static void main(String[] args) throws SQLException {
        /*
         * 练习目标：使用 JDBC 真实连接本机 MySQL。
         *
         * 前置条件：
         * 1. MySQL80 服务正在运行。
         * 2. java_note 数据库已经创建。
         * 3. src/jdbc/JdbcConnectionDemo 已经至少运行过一次，users 表已经存在。
         *
         * TODO:
         * 1. 定义 url、user、password。
         * 2. 使用 try-with-resources 调用 openConnection 建立连接。
         * 3. 执行 SELECT DATABASE(), CURRENT_USER()，输出当前数据库和登录用户。
         * 4. 使用 ResultSet.next() 读取查询结果。
         * 5. 不要输出 password 的真实内容。
         */

        System.out.println("url = " + URL);
        System.out.println("user = " + USER);
        System.out.println("password configured = " + !PASSWORD.isBlank());

        try (Connection connection = openConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT DATABASE() AS databaseName, CURRENT_USER() AS currentUser";
            try (
                    PreparedStatement statement = connection.prepareStatement(sql);
                    ResultSet resultSet = statement.executeQuery()
            ) {
                if (resultSet.next()) {
                    System.out.println("databaseName = " + resultSet.getString("databaseName"));
                    System.out.println("currentUser = " + resultSet.getString("currentUser"));
                }
            }
        }
    }

    static Connection openConnection(String url, String user, String password) throws SQLException {
        // TODO: 使用 DriverManager.getConnection 打开真实数据库连接。
        return DriverManager.getConnection(url, user, password);
    }
}
