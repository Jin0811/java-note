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

        String sql = "select id, name, age from users where name = ? and age >= ?";

        System.out.println(sql);
        System.out.println("1 -> name");
        System.out.println("2 -> minAge");
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
