package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
  ===== ResultSet 映射对象 =====

  JDBC 查询结果会放在 ResultSet 里。
  resultSet.next() 移动到下一行，getLong/getString/getInt 按列取值。

  后端项目里通常不会把 ResultSet 直接传到业务层，而是映射成 Entity/DTO 对象。

  本示例会查询 users 表的全部数据，并把每一行转换成一个 UserRow 对象。
*/

public class ResultSetMappingDemo {

    public static void main(String[] args) {
        try (Connection connection = JdbcDemoSupport.openConnection()) {
            // 让本文件可以单独运行，不依赖其他 Demo 先执行。
            JdbcDemoSupport.ensureUsersTable(connection);
            // ORDER BY 让输出顺序稳定，便于观察数据库结果和对象列表的对应关系。
            String sql = "SELECT id, name, age FROM users ORDER BY id";
            List<UserRow> users = new ArrayList<>();
            
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {
                // ResultSet 每次 next() 移动一行，mapUser 负责读取当前行并创建对象。
                while (resultSet.next()) {
                    users.add(mapUser(resultSet));
                }
            }
            // 这里输出的是 Java 对象，而不是直接输出 ResultSet。
            users.forEach(System.out::println);
        } catch (SQLException e) {
            // 查询和连接相关的异常统一转换为学习时容易阅读的输出。
            JdbcDemoSupport.printSQLException(e);
        }
    }

    /**
     * 把 ResultSet 当前行映射为一个 UserRow。
     * 这个方法必须在 resultSet.next() 成功之后调用，否则当前游标还不在有效数据行上。
     */
    static UserRow mapUser(ResultSet resultSet) throws SQLException {
        // 列名来自 SELECT id, name, age；也可以使用列下标读取，但列名更易读。
        Long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        int age = resultSet.getInt("age");
        return new UserRow(id, name, age);
    }
}

/**
 * @param id UserRow 是一个简单的数据对象，用来承载 users 表的一行结果。
 */
record UserRow(Long id, String name, int age) {
    // 构造方法把数据库查询结果一次性写入对象字段。
}
