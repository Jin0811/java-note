package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
  ===== PreparedStatement =====

  PreparedStatement 用 ? 占位，再用 setXxx 方法填参数。
  好处：
    1. 参数和 SQL 模板分离，更清晰。
    2. 数据库可以预编译 SQL。
    3. 最重要：避免字符串拼接带来的 SQL 注入风险。
*/

public class PreparedStatementDemo {
    public static void main(String[] args) {
        String sql = "select id, name, age from users where name = ? and age >= ?";

        System.out.println(sql);
        System.out.println("第 1 个 ? 使用 setString(1, name)");
        System.out.println("第 2 个 ? 使用 setInt(2, minAge)");
    }

    static PreparedStatement buildStatement(Connection connection, String name, int minAge) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "select id, name, age from users where name = ? and age >= ?"
        );
        statement.setString(1, name);
        statement.setInt(2, minAge);
        return statement;
    }
}
