package quiz.jdbc;

import java.sql.*;

public class Quiz02PreparedStatementQuestion {
    public static void main(String[] args) {
        String sql = "SELECT id, name, age FROM users WHERE name = ? AND age >= ?";
        String name = "Alex";
        int minAge = 20;
        System.out.println(sql);
        System.out.println("name = " + name);
        System.out.println("minAge = " + minAge);

        /*
         * 题目：请针对真实的 java_note.users 表完成练习，不提供标准答案。
         *
         * 1. 使用 Connection.prepareStatement 创建语句。
         * 2. 为两个 ? 绑定 name 和 minAge，并执行 executeQuery。
         * 3. 遍历 ResultSet，输出每一行的 id、name、age。
         *
         * 4. ? 在 SQL 中表示什么？参数下标为什么从 1 开始？
         * ? 代表一个占位符，后续可以通过 statement.setString | statement.setInt 来设置具体值
         * 参数下标与数组不同，这里占位符是从1开始的
         *
         * 5. PreparedStatement 相比字符串拼接如何避免 SQL 注入？
         * String inputName = "' or '1'='1";
         * String safeSql = "SELECT id, name, age FROM users WHERE name = ?";
         * String unsafeSql = "SELECT id, name, age FROM users WHERE name = '" + inputName + "'";
         * 以上述的sql为例子，如果直接进行拼接的话，就会把 or '1'='1 拼接到sql当中，造成这个条件判断一直成立，可以查询到全部数据
         * 采用 PreparedStatement 的话，是通过 statement.setString 的方式设置的，内容会进行处理，有效防止sql注入
         *
         * 6. 在 IDEA 中运行后，实际返回了多少行？请解释原因。
         * 返回了一行数据，因为数据库里面只有一条 name=Alex 并且 age >= 20 的数据
         */
        try (Connection connection = openConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2, minAge);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    System.out.printf(
                        "id=%d, name=%s, age=%d%n",
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static Connection openConnection() throws SQLException {
        String URL = "jdbc:mysql://localhost:3306/java_note";
        String USER = "root";
        String PASSWORD = System.getenv().getOrDefault("JAVA_NOTE_DB_PASSWORD", "123456");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
