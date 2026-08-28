package quiz.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Quiz04ResultSetMappingQuestion {
    public static void main(String[] args) {
        String sql = "SELECT id, name, age FROM users ORDER BY id";
        System.out.println(sql);

        /*
         * 题目：请从真实的 java_note.users 查询结果创建对象，并参考下方标准答案。
         *
         * 1. 使用 Connection 和 Statement 执行 sql。
         *
         * 2. ResultSet.next() 的作用是什么？
         * ResultSet.next() 会将游标移动到下一行，并返回是否存在这一行。
         *
         * 3. 使用 getLong("id")、getString("name")、getInt("age") 读取当前行。
         * 4. 为每一行创建 QuizUserRow，并放入 List。
         *
         * 5. getString("name") 中的 name 表示什么？
         * 表示结果集中的列名，也就是 users 表的 name 列。
         *
         * 6. 为什么要把 ResultSet 映射成对象，而不是把 ResultSet 直接传到业务层？
         * ResultSet 与数据库连接和 JDBC 资源绑定，通常应在数据访问层完成映射，
         * 再把 Entity 或 DTO 对象传给业务层。
         */
        /*
         * ========== 标准答案 ==========
         *
         * 问题 1：如何使用 Connection 和 Statement 执行 sql？
         * 答：先通过 Connection 创建 Statement，再调用 statement.executeQuery(sql)。
         *     executeQuery() 会把 SELECT 语句发送到数据库，并返回 ResultSet。
         *
         * 问题 2：ResultSet.next() 的作用是什么？
         * 答：ResultSet 初始游标位于第一行之前。每次调用 next()，游标向后移动一行，
         *     如果移动后存在数据就返回 true，否则返回 false。因此常用 while (resultSet.next())
         *     遍历所有行，调用 getLong()、getString()、getInt() 读取当前行。
         *
         * 问题 3：如何读取当前行的 id、name、age？
         * 答：使用列名读取：
         *     resultSet.getLong("id")
         *     resultSet.getString("name")
         *     resultSet.getInt("age")
         *     列名需要与 SELECT 返回的列名或列别名对应。
         *
         * 问题 4：为什么要创建 QuizUserRow 并放入 List？
         * 答：每次循环代表一行数据库数据，创建一个 QuizUserRow 保存这一行的字段，
         *     再放入 List，最终就能得到完整的对象集合。当前数据库会得到 3 个对象。
         *
         * 问题 5：getString("name") 中的 name 表示什么？
         * 答：name 表示查询结果中的列名，不是 Java 变量名，也不是表名。
         *     如果 SQL 写成 name AS user_name，就应该使用 getString("user_name")。
         *
         * 问题 6：为什么要把 ResultSet 映射成对象？
         * 答：ResultSet 依赖 Connection、Statement 等 JDBC 资源，不能长期传递到业务层。
         *     映射成 Entity、DTO 或 record 后，业务层只处理 Java 对象，能够降低层之间的耦合，
         *     也更方便测试、传输和控制数据访问资源的生命周期。
         */
        try (Connection connection = openConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            List<QuizUserRow> list = new ArrayList<>();
            while (resultSet.next()) {
                list.add(new QuizUserRow(
                    resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("age")
                ));
            }
            System.out.println(list);
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

record QuizUserRow(Long id, String name, int age) {
}
