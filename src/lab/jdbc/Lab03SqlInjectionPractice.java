package lab.jdbc;

import java.sql.*;

public class Lab03SqlInjectionPractice {
    public static void main(String[] args) {
        /*
         * 练习目标：在真实 users 表上观察 SQL 注入。
         *
         * 这里只允许执行 SELECT，不要把演示 SQL 改成 UPDATE 或 DELETE。
         *
         * TODO:
         * 1. 连接 java_note 数据库，并确保 users 表已经存在。
         * 2. 定义危险输入 "' or '1'='1"。
         * 3. 拼接 unsafeSql，使用 Statement 执行并统计返回行数。
         * 4. 使用 PreparedStatement 执行同样的查询并统计返回行数。
         * 5. 对比两次行数，解释为什么用户输入在两种写法中的含义不同。
         * 不安全的sql里面带有一个or判断，是一直为true的，就查询到了全部的数据
         * 安全的sql是通过prepareStatement来处理和设置参数的，杜绝了sql注入的问题
         */
        String inputName = "' or '1'='1";
        String safeSql = "SELECT id, name, age FROM users WHERE name = ?";
        String unsafeSql = "SELECT id, name, age FROM users WHERE name = '" + inputName + "'";
        // TODO: 使用真实连接分别执行 unsafeSql 和 safeSql。
        System.out.println("inputName = " + inputName);
        System.out.println("safeSql = " + safeSql);
        try (Connection connection = openConnection()) {
            // 危险写法：直接把输入拼到 SQL 中。
            // 最终 SQL 中的 OR 条件可能改变原本的 WHERE 逻辑。
            System.out.println("unsafeSql = " + unsafeSql);
            System.out.println("不安全查询返回行数 = " + countRows(connection, unsafeSql));
            // 安全写法：SQL 模板固定，用户输入通过 ? 单独绑定。
            // 驱动会把 inputName 当作字符串值，不会把其中的引号和 OR 解释成 SQL。
            try (PreparedStatement statement = connection.prepareStatement(safeSql)) {
                statement.setString(1, inputName);
                try (ResultSet resultSet = statement.executeQuery()) {
                    int rowCount = 0;
                    // 这里只统计结果行数，用来直观看出两种写法的差异。
                    while (resultSet.next()) {
                        rowCount++;
                    }
                    System.out.println("safeSql = " + safeSql);
                    System.out.println("安全查询返回行数 = " + rowCount);
                }
            }
        } catch (SQLException e) {
            // 生产项目中还应记录日志，但不应把密码等敏感信息写入日志。
            System.err.println("数据库操作失败：" + e.getMessage());
            System.err.println("SQLState = " + e.getSQLState());
            System.err.println("errorCode = " + e.getErrorCode());
        }
    }

    private static final String URL = "jdbc:mysql://localhost:3306/java_note";
    private static final String USER = "root";
    private static final String PASSWORD = System.getenv().getOrDefault("JAVA_NOTE_DB_PASSWORD", "123456");

    static Connection openConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static int countRows(Connection connection, String sql) throws SQLException {
        int rowCount = 0;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            // Statement 适合执行这里已经拼好的无参数 SQL；参数场景应使用 PreparedStatement。
            while (resultSet.next()) {
                rowCount++;
            }
        }
        return rowCount;
    }
}
