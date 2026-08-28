package lab.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Lab02PreparedStatementPractice {
    private static final String QUERY_SQL =
            "SELECT id, name, age FROM users WHERE name = ? AND age >= ?";
    private static final String URL = "jdbc:mysql://localhost:3306/java_note";
    private static final String USER = "root";
    private static final String PASSWORD = System.getenv().getOrDefault("JAVA_NOTE_DB_PASSWORD", "123456");

    public static void main(String[] args) {
        /*
         * 练习目标：使用 PreparedStatement 查询 java_note.users。
         *
         * 真实表结构：users(id, name, age)。可以先运行 JdbcConnectionDemo 初始化数据。
         *
         * 练习要求：
         * 1. 使用 JDBC 连接 java_note 数据库。
         * 2. 使用带 ? 的 SQL：按 name 精确匹配，并要求 age 大于等于 minAge。
         * 3. 调用 buildStatement，并使用 executeQuery 执行查询。
         * 4. 遍历 ResultSet，输出 id、name、age。
         * 5. 确保 Connection、PreparedStatement、ResultSet 都会关闭。
         */
        String name = "Alex";
        int minAge = 20;

        try (Connection connection = openConnection(URL, USER, PASSWORD)) {
            // 查询场景使用只读 SQL；PreparedStatement 负责绑定用户输入。
            try (
                    PreparedStatement statement = buildStatement(connection, name, minAge);
                    ResultSet resultSet = statement.executeQuery()
            ) {
                int rowCount = 0;
                // 每调用一次 next()，ResultSet 就移动到下一行；返回 false 表示没有下一行。
                while (resultSet.next()) {
                    rowCount++;
                    // getXxx 可以按列名读取当前行的数据，类型应与数据库列类型匹配。
                    System.out.printf(
                            "id=%d, name=%s, age=%d%n",
                            resultSet.getLong("id"),
                            resultSet.getString("name"),
                            resultSet.getInt("age")
                    );
                }
                // rowCount 只是 Java 对查询结果的统计，不会修改数据库。
                System.out.println("匹配行数 = " + rowCount);
            }
        } catch (SQLException e) {
            // 将错误输出到 stderr，并同时输出 SQLState 和错误码，方便定位问题。
            System.err.println("数据库操作失败：" + e.getMessage());
            System.err.println("SQLState = " + e.getSQLState());
            System.err.println("errorCode = " + e.getErrorCode());
        }
    }

    static PreparedStatement buildStatement(Connection connection, String name, int minAge) throws SQLException {
        // ? 的参数下标从 1 开始，不能使用 Java 常见的 0-based 下标。
        PreparedStatement statement = connection.prepareStatement(QUERY_SQL);
        statement.setString(1, name);
        statement.setInt(2, minAge);
        return statement;
    }

    static Connection openConnection(String url, String user, String password) throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
