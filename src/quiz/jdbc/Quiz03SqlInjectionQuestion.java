package quiz.jdbc;

import java.sql.*;

public class Quiz03SqlInjectionQuestion {
    public static void main(String[] args) {
        String input = "' or '1'='1";
        String unsafeSql = "SELECT id, name, age FROM users WHERE name = '" + input + "'";
        String safeSql = "SELECT id, name, age FROM users WHERE name = ?";
        System.out.println(unsafeSql);
        System.out.println(safeSql);

        /*
         * 题目：在 java_note.users 上比较两条只读查询，并理解 SQL 注入的原因。
         *
         * 1. 这个 unsafeSql 最终会被 MySQL 解析成什么条件？
         * 最终的 SQL 是 SELECT id, name, age FROM users WHERE name = '' OR '1'='1'
         * OR 后面的条件始终成立，因此会返回全部数据。
         *
         * 2. 使用 Statement 执行 unsafeSql，统计返回行数。
         * 当前会返回 3 条数据，即 users 表中的全部数据。
         *
         * 3. 使用 PreparedStatement 执行 safeSql，绑定同一个 input，统计返回行数。
         * 当前会返回 0 条数据，因为整个 input 会被当作一个普通的 name 字符串值。
         *
         * 4. 两次查询的结果为什么可能不同？
         * 两次查询使用的是同一个 input，但不安全查询把 input 拼成了 SQL 代码，
         * 安全查询把 input 当作参数值，所以 SQL 结构不同，查询结果也不同。
         *
         * 5. 用户输入应该被当作 SQL 代码还是参数值？
         * 应该当作参数值，如果被当作sql代码，那就有可能出现sql注入
         *
         * 6. 为什么这个演示只使用 SELECT，不使用 UPDATE 或 DELETE？
         * 因为 SELECT 只读，不会修改本机数据；UPDATE 或 DELETE 发生注入时，
         * 可能会意外批量修改或删除数据。
         */
        /*
         * ========== 标准答案 ==========
         *
         * 问题 1：这个 unsafeSql 最终会被 MySQL 解析成什么条件？
         * 答：input 会先通过字符串拼接进入 SQL，最终 SQL 类似：
         *     SELECT id, name, age FROM users WHERE name = '' OR '1'='1'
         *     name = '' 是一个普通条件，OR 后面的 '1'='1' 始终为 true，
         *     所以 WHERE 条件对 users 表中的每一行都成立。
         *
         * 问题 2：使用 Statement 执行 unsafeSql，统计返回行数。
         * 答：当前 java_note.users 表有 3 行，因此 unsafeCount = 3。
         *     这里使用 Statement 是为了直观展示拼接 SQL 被数据库解析后的结果。
         *
         * 问题 3：使用 PreparedStatement 执行 safeSql，绑定同一个 input，统计返回行数。
         * 答：当前 safeCount = 0。safeSql 中的 ? 是参数占位符，
         *     statement.setString(1, input) 会把整个 input 当作 name 的字面值，
         *     其中的引号、OR 和等号不会再被解释为 SQL 语法。
         *
         * 问题 4：两次查询的结果为什么可能不同？
         * 答：区别不在于 input 的内容，而在于 input 进入数据库的方式：
         *     1. 不安全写法在数据库解析 SQL 之前就完成字符串拼接，输入可以改变 SQL 结构。
         *     2. 安全写法先固定 SQL 模板，再单独绑定参数，输入只能作为普通值参与比较。
         *
         * 问题 5：用户输入应该被当作 SQL 代码还是参数值？
         * 答：应该始终当作参数值，并通过 PreparedStatement 的 ? 占位符绑定，
         *     不应该直接拼接到 SQL 字符串中。
         *
         * 问题 6：为什么这个演示只使用 SELECT，不使用 UPDATE 或 DELETE？
         * 答：这不是 JDBC 的强制限制，而是为了保证演示只读且不破坏本机数据。
         *     SQL 注入同样可能出现在 UPDATE 或 DELETE 中，并造成批量修改或删除，
         *     因此真实项目中也必须使用参数化查询和合适的权限控制。
         */
        try (Connection connection = openConnection()) {
            int unsafeCount = 0;
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(unsafeSql)) {
                while (resultSet.next()) {
                    unsafeCount++;
                    System.out.printf(
                        "unsafeSql id=%d, name=%s, age=%d%n",
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age")
                    );
                }
            }
            System.out.println("unsafeSql count = " + unsafeCount);
            int safeCount = 0;
            try (PreparedStatement statement = connection.prepareStatement(safeSql)) {
                statement.setString(1, input);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        safeCount++;
                        System.out.printf(
                            "safeSql id=%d, name=%s, age=%d%n",
                            resultSet.getLong("id"),
                            resultSet.getString("name"),
                            resultSet.getInt("age")
                        );
                    }
                }
            }
            System.out.println("safeSql count = " + safeCount);
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
