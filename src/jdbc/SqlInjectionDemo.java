package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
  ===== SQL 注入风险 =====

  不要把用户输入直接拼进 SQL 字符串。
  如果 name 是 "' or '1'='1"，拼接出来的 SQL 语义会被篡改。

  正确方向：使用 PreparedStatement，把用户输入当作参数，而不是 SQL 代码。

  本示例只执行 SELECT，不会修改数据：
    - 不安全 SQL 会把特殊输入当作 SQL 语法，可能返回全部用户。
    - 安全 SQL 会把同样的输入当作普通字符串，通常返回 0 行。
*/

public class SqlInjectionDemo {
    public static void main(String[] args) {
        // 这段输入模拟用户在登录框或搜索框中提交的恶意内容。
        String inputName = "' or '1'='1";

        try (Connection connection = JdbcDemoSupport.openConnection()) {
            // 初始化只负责准备演示数据，不影响后面对两种查询方式的比较。
            JdbcDemoSupport.ensureUsersTable(connection);

            // 危险写法：直接把输入拼到 SQL 中。
            // 最终 SQL 中的 OR 条件可能改变原本的 WHERE 逻辑。
            String unsafeSql = "SELECT id, name, age FROM users WHERE name = '" + inputName + "'";
            System.out.println("unsafeSql = " + unsafeSql);
            System.out.println("不安全查询返回行数 = " + countRows(connection, unsafeSql));

            // 安全写法：SQL 模板固定，用户输入通过 ? 单独绑定。
            // 驱动会把 inputName 当作字符串值，不会把其中的引号和 OR 解释成 SQL。
            String safeSql = "SELECT id, name, age FROM users WHERE name = ?";
            try (PreparedStatement statement = connection.prepareStatement(safeSql)) {
                statement.setString(1, inputName);
                try (ResultSet resultSet = statement.executeQuery()) {
                    int rowCount = 0;
                    // 这里只统计结果行数，用来直观看出两种写法的差异。
                    while (resultSet.next()) {
                        rowCount++;
                    }
                    System.out.println("safeSql = " + safeSql);
                    System.out.println("安全查询返回行数 = " + rowCount);
                }
            }
        } catch (SQLException e) {
            // 生产项目中还应记录日志，但不应把密码等敏感信息写入日志。
            JdbcDemoSupport.printSQLException(e);
        }
    }

    /**
     * 执行一个只读查询并统计返回行数。
     *
     * 这个方法故意接收完整 SQL，是为了演示不安全拼接的后果；真实项目不应该
     * 用这种方式处理用户输入，更不能把 INSERT/UPDATE/DELETE 语句这样拼接。
     */
    private static int countRows(Connection connection, String sql) throws SQLException {
        int rowCount = 0;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            // Statement 适合执行这里已经拼好的无参数 SQL；参数场景应使用 PreparedStatement。
            while (resultSet.next()) {
                rowCount++;
            }
        }
        return rowCount;
    }
}
