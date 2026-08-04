package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
  ===== JDBC 连接基础 =====

  JDBC 是 Java 标准库提供的数据库访问 API。
  它本身只是规范和一组接口，真正连接 MySQL 还需要额外引入 MySQL Driver。

  连接数据库的核心三件套：
    url      数据库地址，例如 jdbc:mysql://localhost:3306/java_note
    user     用户名
    password 密码

  本示例默认不真的连接数据库，只展示标准写法，避免没有本地 MySQL 时运行失败。
*/

public class JdbcConnectionDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/java_note";
        String user = "root";
        String password = "123456";

        System.out.println("url = " + url);
        System.out.println("user = " + user);
        System.out.println("password length = " + password.length());

        // 真实项目写法：
        // try (Connection connection = DriverManager.getConnection(url, user, password)) {
        //     System.out.println(connection.isValid(2));
        // } catch (SQLException e) {
        //     System.out.println("数据库连接失败：" + e.getMessage());
        // }
    }

    static Connection openConnection(String url, String user, String password) throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
