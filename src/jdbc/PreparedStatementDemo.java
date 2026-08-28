package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
  ===== PreparedStatement =====

  PreparedStatement 用 ? 占位，再用 setXxx 方法填参数。
  好处：
    1. 参数和 SQL 模板分离，更清晰。
    2. 数据库可以预编译 SQL。
    3. 最重要：避免字符串拼接带来的 SQL 注入风险。

  本示例会查询 name 等于 Alex 且 age 不小于 20 的真实数据。
*/

public class PreparedStatementDemo {
    public static void main(String[] args) {
        // 这两个值在真实项目中通常来自请求参数，而不是写死在代码中。
        String name = "Alex";
        int minAge = 20;

        try (Connection connection = JdbcDemoSupport.openConnection()) {
            // 确保查询所依赖的 users 表和示例数据已经准备好。
            JdbcDemoSupport.ensureUsersTable(connection);

            // buildStatement 负责绑定参数，executeQuery 负责执行 SELECT。
            // ResultSet 和 PreparedStatement 都由 try-with-resources 自动关闭。
            try (PreparedStatement statement = buildStatement(connection, name, minAge); ResultSet resultSet = statement.executeQuery()) {
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
            // 例如驱动未加载、密码错误、表不存在或 SQL 语法错误都会在这里报告。
            JdbcDemoSupport.printSQLException(e);
        }
    }

    /**
     * 创建并绑定一个带参数的查询。
     * <p>
     * SQL 中第一个 ? 对应 name，第二个 ? 对应 minAge。
     * 参数下标从 1 开始，setString/setInt 会把值作为参数传递，而不是 SQL 代码拼接进去。
     * 返回的 PreparedStatement 由调用方负责关闭。
     */
    static PreparedStatement buildStatement(Connection connection, String name, int minAge) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT id, name, age FROM users WHERE name = ? AND age >= ?"
        );
        statement.setString(1, name);
        statement.setInt(2, minAge);
        return statement;
    }
}
