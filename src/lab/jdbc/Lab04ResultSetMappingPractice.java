package lab.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Lab04ResultSetMappingPractice {
    public static void main(String[] args) {
        /*
         * 练习目标：查询真实 users 表，并把每一行映射成 Java 对象。
         *
         * TODO:
         * 1. 连接 java_note 数据库。
         * 2. 执行 SELECT id, name, age FROM users ORDER BY id。
         * 3. 每次 resultSet.next() 成功后，调用 mapUser 映射当前行。
         * 4. 把所有 UserRow 放入 List 并输出。
         * 5. 关闭 Connection、Statement 和 ResultSet。
         */
        String sql = "SELECT id, name, age FROM users ORDER BY id";
        List<UserRow> users = new ArrayList<>();
        // TODO: 使用真实连接执行 sql，把 ResultSet 映射为 UserRow。
        System.out.println("sql = " + sql);
        try (Connection connection = openConnection()) {
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    users.add(mapUser(resultSet));
                }
            }
            users.forEach(System.out::println);
        } catch (SQLException e) {
            // 生产项目中还应记录日志，但不应把密码等敏感信息写入日志。
            System.err.println("数据库操作失败：" + e.getMessage());
            System.err.println("SQLState = " + e.getSQLState());
            System.err.println("errorCode = " + e.getErrorCode());
        }
    }

    static UserRow mapUser(ResultSet resultSet) throws SQLException {
        // TODO: 从 ResultSet 读取 id、name、age，并创建 UserRow。
        return new UserRow(
            resultSet.getLong("id"),
            resultSet.getString("name"),
            resultSet.getInt("age")
        );
    }

    private static final String URL = "jdbc:mysql://localhost:3306/java_note";
    private static final String USER = "root";
    private static final String PASSWORD = System.getenv().getOrDefault("JAVA_NOTE_DB_PASSWORD", "123456");

    static Connection openConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

record UserRow(Long id, String name, int age) {
}
