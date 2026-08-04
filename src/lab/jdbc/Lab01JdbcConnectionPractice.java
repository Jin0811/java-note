package lab.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Lab01JdbcConnectionPractice {
    public static void main(String[] args) {
        /*
         * 练习目标：JDBC 连接参数。
         *
         * TODO:
         * 1. 定义 url、user、password。
         * 2. 输出这些配置。
         * 3. 阅读 openConnection 方法，理解 DriverManager.getConnection。
         */

        String url = "jdbc:mysql://localhost:3306/java_note";
        String user = "root";
        String password = "123456";

        System.out.println(url);
        System.out.println(user);
        System.out.println(password.length());
    }

    static Connection openConnection(String url, String user, String password) throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
