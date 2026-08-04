package lab.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Lab02PreparedStatementPractice {
    public static void main(String[] args) {
        /*
         * 练习目标：PreparedStatement 占位符。
         *
         * TODO:
         * 1. 写出带 ? 的查询 SQL。
         * 2. 输出每个 ? 对应的参数位置。
         * 3. 阅读 buildStatement 方法，理解 setString / setInt。
         */
    }

    static PreparedStatement buildStatement(Connection connection, String name, int minAge) throws SQLException {
        // TODO: 创建 PreparedStatement，并设置 name、minAge 参数。
        return null;
    }
}
