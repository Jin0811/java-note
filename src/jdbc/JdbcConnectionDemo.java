package jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
  ===== JDBC 连接基础 =====

  JDBC 是 Java 标准库提供的数据库访问 API。
  它本身只是规范和一组接口，真正连接 MySQL 还需要额外引入 MySQL Driver。

  JDBC 对象关系可以理解为：
    DriverManager
        -> Connection
            -> Statement 或 PreparedStatement
                -> executeQuery()
                    -> ResultSet

  这些名词分别表示：
    DriverManager：驱动管理器。根据数据库 URL 找到合适的 JDBC 驱动，
                   并通过 getConnection() 创建数据库连接。
    Connection：Java 程序和数据库之间的一次连接会话。它可以创建多个 SQL 执行对象，
                还可以管理事务，例如 commit() 和 rollback()。
    Statement：执行固定 SQL 的对象，适合没有参数的简单 SQL。
    PreparedStatement：Statement 的参数化版本。SQL 中可以使用 ? 占位符，
                       再通过 setString()、setInt() 等方法设置参数，能够避免 SQL 注入，
                       也是实际开发中更常用的选择。
    executeQuery()：Statement 或 PreparedStatement 的方法，用来真正执行 SELECT 查询。
                    查询结果会以 ResultSet 的形式返回。
    ResultSet：查询结果集，可以理解为指向多行结果的游标。调用 next() 移动到下一行，
               再通过 getString()、getInt() 等方法读取当前行的列值。

  一次典型的 JDBC 查询流程是：
    1. DriverManager 根据 URL、用户名和密码获取 Connection。
    2. Connection 创建 Statement 或 PreparedStatement。
    3. PreparedStatement 接收 SQL 和参数；SQL 此时还没有真正发送到数据库。
    4. 调用 executeQuery()，把 SELECT SQL 发送到数据库并得到 ResultSet。
    5. 调用 ResultSet.next()，逐行读取查询结果。
    6. 查询结束后按 ResultSet、Statement、Connection 的顺序释放资源。

  try-with-resources 可以自动完成第 6 步，并且关闭顺序与资源声明顺序相反。

  连接数据库的核心三件套：
    url      数据库地址，例如 jdbc:mysql://localhost:3306/java_note
    user     用户名
    password 密码

  本示例会真实连接本机 MySQL，并执行一个简单查询。
*/

public class JdbcConnectionDemo {
    public static void main(String[] args) {
        // JdbcDemoSupport.openConnection() 内部会调用 DriverManager.getConnection()，
        // 使用 URL、用户名和密码创建一次 Connection 会话。
        // try-with-resources 会在代码块结束时自动关闭 Connection，即使中途抛出异常也会关闭。
        // 关闭连接非常重要，否则程序运行次数增加后可能耗尽数据库连接资源。
        try (Connection connection = JdbcDemoSupport.openConnection()) {
            // 为了让四个 Demo 可以独立运行，这里先确保共享示例表存在。
            JdbcDemoSupport.ensureUsersTable(connection);

            // DatabaseMetaData 提供数据库产品、JDBC 驱动版本等连接元信息。
            DatabaseMetaData metadata = connection.getMetaData();
            System.out.println("连接成功");
            System.out.println("url = " + JdbcDemoSupport.getUrl());
            System.out.println("user = " + JdbcDemoSupport.getUser());
            System.out.println("driver = " + metadata.getDriverName());
            System.out.println("driver version = " + metadata.getDriverVersion());

            // isValid 会向驱动询问连接是否仍然有效；参数 2 表示最多等待 2 秒。
            System.out.println("connection valid = " + connection.isValid(2));

            // 这是一个不需要外部参数的查询，但仍使用 PreparedStatement，便于保持统一写法。
            // 此时只是把 SQL 保存到 String 中，还没有发送到数据库。
            // DATABASE() 返回当前连接选择的数据库，COUNT(*) 统计 users 表的行数。
            String sql = "SELECT DATABASE() AS database_name, COUNT(*) AS user_count FROM users";

            // Connection 创建一个与当前连接会话绑定的 PreparedStatement。
            // 如果 SQL 中有 ? 占位符，可以在 executeQuery() 前调用 setString()、setInt() 等方法赋值。
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 // executeQuery() 在这里真正执行 SELECT，并返回查询结果集。
                 ResultSet resultSet = statement.executeQuery()) {
                // ResultSet 初始位置在第一行之前，必须先调用 next() 才能读取数据。
                if (resultSet.next()) {
                    System.out.println("database = " + resultSet.getString("database_name"));
                    System.out.println("users count = " + resultSet.getInt("user_count"));
                }
                // 内层 try-with-resources 结束时会先关闭 ResultSet，再关闭 PreparedStatement；
                // 外层 try-with-resources 结束时再关闭 Connection。
            }
        } catch (SQLException e) {
            // 连接失败、SQL 语法错误、权限错误等 JDBC 问题都会进入这里。
            JdbcDemoSupport.printSQLException(e);
        }
    }

    /**
     * 展示 JDBC 最原始的连接写法。
     *
     * 其他 Demo 使用 JdbcDemoSupport 统一读取配置；保留这个方法是为了让学习者看到
     * DriverManager.getConnection(url, user, password) 的标准参数形式。
     */
    static Connection openConnection(String url, String user, String password) throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
